package com.lorikyo.recipestash.models

import com.google.gson.annotations.SerializedName

data class FilterMeal(
    @field:SerializedName("strMeal") val strMeal: String,
    @field:SerializedName("strMealThumb") val strMealThumb: String,
    @field:SerializedName("idMeal") val idMeal: String,
)
