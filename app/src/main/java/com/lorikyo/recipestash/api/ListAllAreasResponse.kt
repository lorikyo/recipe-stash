package com.lorikyo.recipestash.api

import com.google.gson.annotations.SerializedName
import com.lorikyo.recipestash.models.AreaDto

data class ListAllAreasResponse(
    @field:SerializedName("meals") val meals: List<AreaResponse>
)