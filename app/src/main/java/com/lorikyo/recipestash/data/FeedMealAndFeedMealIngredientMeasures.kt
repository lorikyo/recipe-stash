package com.lorikyo.recipestash.data

import androidx.room.Embedded
import androidx.room.Relation

data class FeedMealAndFeedMealIngredientMeasures(
    @Embedded
    val feedMeal: FeedMeal,

    @Relation(parentColumn = "id", entityColumn = "meal_id")
    val feedMealIngredientMeasures: List<FeedMealIngredientMeasure>
)
