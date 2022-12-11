package com.lorikyo.recipestash.models

import com.google.gson.annotations.SerializedName

data class IngredientDto(
    @field:SerializedName("id_ingredient") val idIngredient: String,
    @field:SerializedName("str_ingredient") val strIngredient: String,
    @field:SerializedName("str_description") val strDescription: String,
    @field:SerializedName("str_type") val strType: String,
)