package com.lorikyo.recipestash.models

import com.lorikyo.recipestash.api.MealDBService
import com.lorikyo.recipestash.data.MealOfTheDay
import com.lorikyo.recipestash.data.MealOfTheDayDao
import com.lorikyo.recipestash.utilities.Source
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealOfTheDayRepository @Inject constructor(private val mealOfTheDayDao: MealOfTheDayDao, private val mealDBService: MealDBService) {

    fun getMealOfTheDay(): Flow<MealDto?> {
        val meal = mealOfTheDayDao.getMealOfTheDay().map {
            var result: MealDto? = null

            if(it.isNotEmpty()) {
                val x = it[0]
                result = MealDto(
                    id = null,
                    dateTimeModified = x.dateTimeModified,
                    source = x.source,
                    idMeal = x.idMeal,
                    strMeal = x.strMeal,
                    strDrinkAlternate = x.strDrinkAlternate,
                    strCategory = x.strCategory,
                    strArea = x.strArea,
                    strInstructions = x.strInstructions,
                    strMealThumb = x.strMealThumb,
                    strTags = x.strTags,
                    strYoutube = x.strYoutube,
                    strIngredient1 = x.strIngredient1,
                    strIngredient2 = x.strIngredient2,
                    strIngredient3 = x.strIngredient3,
                    strIngredient4 = x.strIngredient4,
                    strIngredient5 = x.strIngredient5,
                    strIngredient6 = x.strIngredient6,
                    strIngredient7 = x.strIngredient7,
                    strIngredient8 = x.strIngredient8,
                    strIngredient9 = x.strIngredient9,
                    strIngredient10 = x.strIngredient10,
                    strIngredient11 = x.strIngredient11,
                    strIngredient12 = x.strIngredient12,
                    strIngredient13 = x.strIngredient13,
                    strIngredient14 = x.strIngredient14,
                    strIngredient15 = x.strIngredient15,
                    strIngredient16 = x.strIngredient16,
                    strIngredient17 = x.strIngredient17,
                    strIngredient18 = x.strIngredient18,
                    strIngredient19 = x.strIngredient19,
                    strIngredient20 = x.strIngredient20,
                    strMeasure1 = x.strMeasure1,
                    strMeasure2 = x.strMeasure2,
                    strMeasure3 = x.strMeasure3,
                    strMeasure4 = x.strMeasure4,
                    strMeasure5 = x.strMeasure5,
                    strMeasure6 = x.strMeasure6,
                    strMeasure7 = x.strMeasure7,
                    strMeasure8 = x.strMeasure8,
                    strMeasure9 = x.strMeasure9,
                    strMeasure10 = x.strMeasure10,
                    strMeasure11 = x.strMeasure11,
                    strMeasure12 = x.strMeasure12,
                    strMeasure13 = x.strMeasure13,
                    strMeasure14 = x.strMeasure14,
                    strMeasure15 = x.strMeasure15,
                    strMeasure16 = x.strMeasure16,
                    strMeasure17 = x.strMeasure17,
                    strMeasure18 = x.strMeasure18,
                    strMeasure19 = x.strMeasure19,
                    strMeasure20 = x.strMeasure20,
                    strSource = x.strSource,
                    strImageSource = x.strImageSource,
                    strCreativeCommonsConfirmed = x.strCreativeCommonsConfirmed,
                    dateModified = x.dateModified,
                )
            }
            result
        }
        return meal
    }

    suspend fun refreshMealOfTheDay() {
        withContext(Dispatchers.IO) {
            mealOfTheDayDao.deleteAll()
            val mealOfTheDay = mealDBService.lookupSingleRandomMeal().meals.map {
                MealOfTheDay(
                    dateTimeModified = System.currentTimeMillis(),
                    source = Source.MEALDB.source,
                    idMeal = it.idMeal,
                    strMeal = it.strMeal,
                    strDrinkAlternate = it.strDrinkAlternate,
                    strCategory = it.strCategory,
                    strArea = it.strArea,
                    strInstructions = it.strInstructions,
                    strMealThumb = it.strMealThumb,
                    strTags = it.strTags,
                    strYoutube = it.strYoutube,
                    strIngredient1 = it.strIngredient1,
                    strIngredient2 = it.strIngredient2,
                    strIngredient3 = it.strIngredient3,
                    strIngredient4 = it.strIngredient4,
                    strIngredient5 = it.strIngredient5,
                    strIngredient6 = it.strIngredient6,
                    strIngredient7 = it.strIngredient7,
                    strIngredient8 = it.strIngredient8,
                    strIngredient9 = it.strIngredient9,
                    strIngredient10 = it.strIngredient10,
                    strIngredient11 = it.strIngredient11,
                    strIngredient12 = it.strIngredient12,
                    strIngredient13 = it.strIngredient13,
                    strIngredient14 = it.strIngredient14,
                    strIngredient15 = it.strIngredient15,
                    strIngredient16 = it.strIngredient16,
                    strIngredient17 = it.strIngredient17,
                    strIngredient18 = it.strIngredient18,
                    strIngredient19 = it.strIngredient19,
                    strIngredient20 = it.strIngredient20,
                    strMeasure1 = it.strMeasure1,
                    strMeasure2 = it.strMeasure2,
                    strMeasure3 = it.strMeasure3,
                    strMeasure4 = it.strMeasure4,
                    strMeasure5 = it.strMeasure5,
                    strMeasure6 = it.strMeasure6,
                    strMeasure7 = it.strMeasure7,
                    strMeasure8 = it.strMeasure8,
                    strMeasure9 = it.strMeasure9,
                    strMeasure10 = it.strMeasure10,
                    strMeasure11 = it.strMeasure11,
                    strMeasure12 = it.strMeasure12,
                    strMeasure13 = it.strMeasure13,
                    strMeasure14 = it.strMeasure14,
                    strMeasure15 = it.strMeasure15,
                    strMeasure16 = it.strMeasure16,
                    strMeasure17 = it.strMeasure17,
                    strMeasure18 = it.strMeasure18,
                    strMeasure19 = it.strMeasure19,
                    strMeasure20 = it.strMeasure20,
                    strSource = it.strSource,
                    strImageSource = it.strImageSource,
                    strCreativeCommonsConfirmed = it.strCreativeCommonsConfirmed,
                    dateModified = it.dateModified,
                )
            }[0]

            mealOfTheDayDao.insert(mealOfTheDay)
        }
    }

}