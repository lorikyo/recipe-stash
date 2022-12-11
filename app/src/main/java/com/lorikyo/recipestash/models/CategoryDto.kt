package com.lorikyo.recipestash.models

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @field:SerializedName("strCategory") val strCategory: String,
)
