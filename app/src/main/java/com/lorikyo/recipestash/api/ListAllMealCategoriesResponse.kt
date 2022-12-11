package com.lorikyo.recipestash.api

import com.google.gson.annotations.SerializedName

data class ListAllMealCategoriesResponse(
    @field:SerializedName("categories") val categories: List<CategoryResponse>
)
