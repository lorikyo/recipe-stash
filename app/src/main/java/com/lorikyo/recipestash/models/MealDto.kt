package com.lorikyo.recipestash.models

data class MealDto(
    val id: Long?,
    val dateTimeModified: Long?,
    val source: String?,
    var isAddedToStash: Boolean?,

    val idMeal: String?,
    val strMeal: String?,
    val strDrinkAlternate: String?,
    val strCategory: String?,
    val strArea: String?,
    val strInstructions: String?,
    val strMealThumb: String?,
    val strTags: String?,
    val strYoutube: String?,
    val strSource: String?,
    val strImageSource: String?,
    val strCreativeCommonsConfirmed: String?,
    val dateModified: String?,

    val ingredientMeasures: List<IngredientMeasureDto> = listOf(),
)
