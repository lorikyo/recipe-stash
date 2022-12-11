package com.lorikyo.recipestash.data

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryAndMeals(

    @Embedded
    val category: Category,

    @Relation(parentColumn = "str_category", entityColumn = "str_category")
    val meals: List<Meal>
)
