package com.lorikyo.recipestash.api

import com.google.gson.annotations.SerializedName

data class SearchMealsResponse(
    @field:SerializedName("meals") val meals: List<MealResponse>
)
