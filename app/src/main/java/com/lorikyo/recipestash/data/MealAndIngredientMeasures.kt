package com.lorikyo.recipestash.data

import androidx.room.Embedded
import androidx.room.Relation

data class MealAndIngredientMeasures(
    @Embedded
    val meal: Meal,

    @Relation(parentColumn = "id", entityColumn = "meal_id")
    val ingredientMeasures: List<IngredientMeasure>
)
