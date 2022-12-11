package com.lorikyo.recipestash.api

import com.google.gson.annotations.SerializedName
import com.lorikyo.recipestash.models.FilterMeal

data class FilterMealResponse(
    @field:SerializedName("meals") val meals: List<FilterMeal>,
)
