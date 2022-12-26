package com.lorikyo.recipestash.models

import com.lorikyo.recipestash.api.MealDBService
import com.lorikyo.recipestash.data.*
import com.lorikyo.recipestash.utilities.Source
import com.lorikyo.recipestash.utilities.getCurrentMilliseconds
import com.lorikyo.recipestash.utilities.isBeforeToday
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeedMealRepository @Inject constructor(
    private val feedMealDao: FeedMealDao,
    private val feedMealIngredientMeasureDao: FeedMealIngredientMeasureDao,
    private val mealDao: MealDao,
    private val mealDBService: MealDBService,
    private val transactionProvider: TransactionProvider,
) {

    suspend fun getFeedMeal(): Flow<MealDto?> {
        return feedMealDao.getFeedMealAndFeedMealIngredientMeasures().map {
            var result: MealDto? = null
            it?.let {
                var isAddedToStash = false
                it.feedMeal.idMeal?.let {
                    if (mealDao.getMealByIdMeal(it) !== null) {
                        isAddedToStash = true
                    }
                }

                result = MealDto(
                    id = null,
                    dateTimeModified = it.feedMeal.dateTimeModified,
                    source = it.feedMeal.source,
                    isAddedToStash = isAddedToStash,
                    idMeal = it.feedMeal.idMeal,
                    strMeal = it.feedMeal.strMeal,
                    strDrinkAlternate = it.feedMeal.strDrinkAlternate,
                    strCategory = it.feedMeal.strCategory,
                    strArea = it.feedMeal.strArea,
                    strInstructions = it.feedMeal.strInstructions,
                    strMealThumb = it.feedMeal.strMealThumb,
                    strTags = it.feedMeal.strTags,
                    strYoutube = it.feedMeal.strYoutube,
                    strSource = it.feedMeal.strSource,
                    strImageSource = it.feedMeal.strImageSource,
                    strCreativeCommonsConfirmed = it.feedMeal.strCreativeCommonsConfirmed,
                    dateModified = it.feedMeal.dateModified,
                    ingredientMeasures = it.feedMealIngredientMeasures.map { x ->
                        IngredientMeasureDto(id = x.id, name = x.name, measure = x.measure)
                    }
                )
            }

            if (it == null || isBeforeToday(it.feedMeal.dateTimeModified)) {
                refreshFeedMeal()
            }

            result
        }
    }

    suspend fun refreshFeedMeal() {
        withContext(Dispatchers.IO) {
            transactionProvider.runAsTransaction {
                feedMealIngredientMeasureDao.deleteAll()
                feedMealDao.deleteAll()
            }

            val mealResponse = mealDBService.lookupSingleRandomMeal().meals[0]
            val feedMeal = FeedMeal(
                dateTimeModified = getCurrentMilliseconds(),
                source = Source.MEALDB.source,
                idMeal = mealResponse.idMeal,
                strMeal = mealResponse.strMeal,
                strDrinkAlternate = mealResponse.strDrinkAlternate,
                strCategory = mealResponse.strCategory,
                strArea = mealResponse.strArea,
                strInstructions = mealResponse.strInstructions,
                strMealThumb = mealResponse.strMealThumb,
                strTags = mealResponse.strTags,
                strYoutube = mealResponse.strYoutube,
                strSource = mealResponse.strSource,
                strImageSource = mealResponse.strImageSource,
                strCreativeCommonsConfirmed = mealResponse.strCreativeCommonsConfirmed,
                dateModified = mealResponse.dateModified,
            )
            val feedMealId = feedMealDao.insert(feedMeal)

            val feedMealIngredientMeasures = mutableListOf<FeedMealIngredientMeasure>()
            if (!mealResponse.strIngredient1.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient1, mealResponse.strMeasure1, feedMealId))
            }
            if (!mealResponse.strIngredient2.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient2, mealResponse.strMeasure2, feedMealId))
            }
            if (!mealResponse.strIngredient3.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient3, mealResponse.strMeasure3, feedMealId))
            }
            if (!mealResponse.strIngredient4.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient4, mealResponse.strMeasure4, feedMealId))
            }
            if (!mealResponse.strIngredient5.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient5, mealResponse.strMeasure5, feedMealId))
            }
            if (!mealResponse.strIngredient6.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient6, mealResponse.strMeasure6, feedMealId))
            }
            if (!mealResponse.strIngredient7.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient7, mealResponse.strMeasure7, feedMealId))
            }
            if (!mealResponse.strIngredient8.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient8, mealResponse.strMeasure8, feedMealId))
            }
            if (!mealResponse.strIngredient9.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient9, mealResponse.strMeasure9, feedMealId))
            }
            if (!mealResponse.strIngredient10.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient10, mealResponse.strMeasure10, feedMealId))
            }
            if (!mealResponse.strIngredient11.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient11, mealResponse.strMeasure11, feedMealId))
            }
            if (!mealResponse.strIngredient12.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient12, mealResponse.strMeasure12, feedMealId))
            }
            if (!mealResponse.strIngredient13.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient13, mealResponse.strMeasure13, feedMealId))
            }
            if (!mealResponse.strIngredient14.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient14, mealResponse.strMeasure14, feedMealId))
            }
            if (!mealResponse.strIngredient15.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient15, mealResponse.strMeasure15, feedMealId))
            }
            if (!mealResponse.strIngredient16.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient16, mealResponse.strMeasure16, feedMealId))
            }
            if (!mealResponse.strIngredient17.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient17, mealResponse.strMeasure17, feedMealId))
            }
            if (!mealResponse.strIngredient18.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient18, mealResponse.strMeasure18, feedMealId))
            }
            if (!mealResponse.strIngredient19.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient19, mealResponse.strMeasure19, feedMealId))
            }
            if (!mealResponse.strIngredient20.isNullOrEmpty()) {
                feedMealIngredientMeasures.add(FeedMealIngredientMeasure(mealResponse.strIngredient20, mealResponse.strMeasure20, feedMealId))
            }
            feedMealIngredientMeasureDao.insertAll(feedMealIngredientMeasures)
        }
    }

}