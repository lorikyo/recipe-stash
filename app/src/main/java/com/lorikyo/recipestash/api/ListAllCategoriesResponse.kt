package com.lorikyo.recipestash.api

import com.google.gson.annotations.SerializedName
import com.lorikyo.recipestash.models.CategoryDto

data class ListAllCategoriesResponse(
    @field:SerializedName("meals") val meals: List<CategoryResponse>
)