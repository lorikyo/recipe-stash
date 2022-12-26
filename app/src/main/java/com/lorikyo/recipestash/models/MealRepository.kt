package com.lorikyo.recipestash.models

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.lorikyo.recipestash.data.*
import com.lorikyo.recipestash.utilities.Source
import com.lorikyo.recipestash.utilities.getCurrentMilliseconds
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealRepository @Inject constructor(
    private val mealDao: MealDao,
    private val ingredientMeasureDao: IngredientMeasureDao,
    private val transactionProvider: TransactionProvider,
) {

    fun searchMeals(): Flow<PagingData<MealDto>> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { MealPagingSource(mealDao) }
        ).flow
            .map { x ->
                x.map { y ->
                    MealDto(
                        id = y.id,
                        dateTimeModified = y.dateTimeModified,
                        source = y.source,
                        isAddedToStash = true,
                        idMeal = y.idMeal,
                        strMeal = y.strMeal,
                        strDrinkAlternate = y.strDrinkAlternate,
                        strCategory = y.strCategory,
                        strArea = y.strArea,
                        strInstructions = y.strInstructions,
                        strMealThumb = y.strMealThumb,
                        strTags = y.strTags,
                        strYoutube = y.strYoutube,
                        strSource = y.strSource,
                        strImageSource = y.strImageSource,
                        strCreativeCommonsConfirmed = y.strCreativeCommonsConfirmed,
                        dateModified = y.dateModified,
                    )
                }
            }
    }

    suspend fun addMealToStash(mealDto: MealDto) {
        val meal = Meal(
            dateTimeModified = getCurrentMilliseconds(),
            source = Source.MEALDB.source,
            idMeal = mealDto.idMeal,
            strMeal = mealDto.strMeal,
            strDrinkAlternate = mealDto.strDrinkAlternate,
            strCategory = mealDto.strCategory,
            strArea = mealDto.strArea,
            strInstructions = mealDto.strInstructions,
            strMealThumb = mealDto.strMealThumb,
            strTags = mealDto.strTags,
            strYoutube = mealDto.strYoutube,
            strSource = mealDto.strSource,
            strImageSource = mealDto.strImageSource,
            strCreativeCommonsConfirmed = mealDto.strCreativeCommonsConfirmed,
            dateModified = mealDto.dateModified,
        )
        val mealId = mealDao.insert(meal)

        val ingredientMeasures = mealDto.ingredientMeasures.map {
            IngredientMeasure(name = it.name, measure = it.measure, mealId = mealId)
        }
        ingredientMeasureDao.insertAll(ingredientMeasures)
    }

}