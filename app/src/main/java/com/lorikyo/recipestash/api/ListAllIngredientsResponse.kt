package com.lorikyo.recipestash.api

import com.google.gson.annotations.SerializedName
import com.lorikyo.recipestash.models.IngredientDto

data class ListAllIngredientsResponse(
    @field:SerializedName("meals") val meals: List<IngredientDto>
)