package com.lorikyo.recipestash.data

import androidx.room.Embedded
import androidx.room.Relation

data class AreaAndMeals(

    @Embedded
    val area: Area,

    @Relation(parentColumn = "str_area", entityColumn = "str_area")
    val meals: List<Meal>
)
