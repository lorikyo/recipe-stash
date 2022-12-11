package com.lorikyo.recipestash.models

import com.lorikyo.recipestash.data.MealDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealRepository @Inject constructor(private val mealDao: MealDao) {

    fun getMeals(): Flow<List<MealDto>> {
        val mealList = mealDao.getMeals().map { x ->
            x.map { y ->
                MealDto(
                    id = y.id,
                    dateTimeModified = y.dateTimeModified,
                    source = y.source,
                    idMeal = y.idMeal,
                    strMeal = y.strMeal,
                    strDrinkAlternate = y.strDrinkAlternate,
                    strCategory = y.strCategory,
                    strArea = y.strArea,
                    strInstructions = y.strInstructions,
                    strMealThumb = y.strMealThumb,
                    strTags = y.strTags,
                    strYoutube = y.strYoutube,
                    strIngredient1 = y.strIngredient1,
                    strIngredient2 = y.strIngredient2,
                    strIngredient3 = y.strIngredient3,
                    strIngredient4 = y.strIngredient4,
                    strIngredient5 = y.strIngredient5,
                    strIngredient6 = y.strIngredient6,
                    strIngredient7 = y.strIngredient7,
                    strIngredient8 = y.strIngredient8,
                    strIngredient9 = y.strIngredient9,
                    strIngredient10 = y.strIngredient10,
                    strIngredient11 = y.strIngredient11,
                    strIngredient12 = y.strIngredient12,
                    strIngredient13 = y.strIngredient13,
                    strIngredient14 = y.strIngredient14,
                    strIngredient15 = y.strIngredient15,
                    strIngredient16 = y.strIngredient16,
                    strIngredient17 = y.strIngredient17,
                    strIngredient18 = y.strIngredient18,
                    strIngredient19 = y.strIngredient19,
                    strIngredient20 = y.strIngredient20,
                    strMeasure1 = y.strMeasure1,
                    strMeasure2 = y.strMeasure2,
                    strMeasure3 = y.strMeasure3,
                    strMeasure4 = y.strMeasure4,
                    strMeasure5 = y.strMeasure5,
                    strMeasure6 = y.strMeasure6,
                    strMeasure7 = y.strMeasure7,
                    strMeasure8 = y.strMeasure8,
                    strMeasure9 = y.strMeasure9,
                    strMeasure10 = y.strMeasure10,
                    strMeasure11 = y.strMeasure11,
                    strMeasure12 = y.strMeasure12,
                    strMeasure13 = y.strMeasure13,
                    strMeasure14 = y.strMeasure14,
                    strMeasure15 = y.strMeasure15,
                    strMeasure16 = y.strMeasure16,
                    strMeasure17 = y.strMeasure17,
                    strMeasure18 = y.strMeasure18,
                    strMeasure19 = y.strMeasure19,
                    strMeasure20 = y.strMeasure20,
                    strSource = y.strSource,
                    strImageSource = y.strImageSource,
                    strCreativeCommonsConfirmed = y.strCreativeCommonsConfirmed,
                    dateModified = y.dateModified,
                )
            }
        }
        return mealList
    }
}