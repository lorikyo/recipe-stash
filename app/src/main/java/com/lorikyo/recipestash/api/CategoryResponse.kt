package com.lorikyo.recipestash.api

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @field:SerializedName("strCategory") val strCategory: String,
)
