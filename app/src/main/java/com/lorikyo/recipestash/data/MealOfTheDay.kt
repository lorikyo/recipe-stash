package com.lorikyo.recipestash.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_of_the_day")
data class MealOfTheDay(
    @ColumnInfo(name = "datetime_modified") val dateTimeModified: Long,
    @ColumnInfo(name = "source") val source: String,

    @ColumnInfo(name = "id_meal") val idMeal: String?,
    @ColumnInfo(name = "str_meal") val strMeal: String?,
    @ColumnInfo(name = "str_drink_alternate") val strDrinkAlternate: String?,
    @ColumnInfo(name = "str_category") val strCategory: String?,
    @ColumnInfo(name = "str_area") val strArea: String?,
    @ColumnInfo(name = "str_instructions") val strInstructions: String?,
    @ColumnInfo(name = "str_meal_thumb") val strMealThumb: String?,
    @ColumnInfo(name = "str_tags") val strTags: String?,
    @ColumnInfo(name = "str_youtube") val strYoutube: String?,
    @ColumnInfo(name = "str_ingredient_1") val strIngredient1: String?,
    @ColumnInfo(name = "str_ingredient_2") val strIngredient2: String?,
    @ColumnInfo(name = "str_ingredient_3") val strIngredient3: String?,
    @ColumnInfo(name = "str_ingredient_4") val strIngredient4: String?,
    @ColumnInfo(name = "str_ingredient_5") val strIngredient5: String?,
    @ColumnInfo(name = "str_ingredient_6") val strIngredient6: String?,
    @ColumnInfo(name = "str_ingredient_7") val strIngredient7: String?,
    @ColumnInfo(name = "str_ingredient_8") val strIngredient8: String?,
    @ColumnInfo(name = "str_ingredient_9") val strIngredient9: String?,
    @ColumnInfo(name = "str_ingredient_10") val strIngredient10: String?,
    @ColumnInfo(name = "str_ingredient_11") val strIngredient11: String?,
    @ColumnInfo(name = "str_ingredient_12") val strIngredient12: String?,
    @ColumnInfo(name = "str_ingredient_13") val strIngredient13: String?,
    @ColumnInfo(name = "str_ingredient_14") val strIngredient14: String?,
    @ColumnInfo(name = "str_ingredient_15") val strIngredient15: String?,
    @ColumnInfo(name = "str_ingredient_16") val strIngredient16: String?,
    @ColumnInfo(name = "str_ingredient_17") val strIngredient17: String?,
    @ColumnInfo(name = "str_ingredient_18") val strIngredient18: String?,
    @ColumnInfo(name = "str_ingredient_19") val strIngredient19: String?,
    @ColumnInfo(name = "str_ingredient_20") val strIngredient20: String?,
    @ColumnInfo(name = "str_measure_1") val strMeasure1: String?,
    @ColumnInfo(name = "str_measure_2") val strMeasure2: String?,
    @ColumnInfo(name = "str_measure_3") val strMeasure3: String?,
    @ColumnInfo(name = "str_measure_4") val strMeasure4: String?,
    @ColumnInfo(name = "str_measure_5") val strMeasure5: String?,
    @ColumnInfo(name = "str_measure_6") val strMeasure6: String?,
    @ColumnInfo(name = "str_measure_7") val strMeasure7: String?,
    @ColumnInfo(name = "str_measure_8") val strMeasure8: String?,
    @ColumnInfo(name = "str_measure_9") val strMeasure9: String?,
    @ColumnInfo(name = "str_measure_10") val strMeasure10: String?,
    @ColumnInfo(name = "str_measure_11") val strMeasure11: String?,
    @ColumnInfo(name = "str_measure_12") val strMeasure12: String?,
    @ColumnInfo(name = "str_measure_13") val strMeasure13: String?,
    @ColumnInfo(name = "str_measure_14") val strMeasure14: String?,
    @ColumnInfo(name = "str_measure_15") val strMeasure15: String?,
    @ColumnInfo(name = "str_measure_16") val strMeasure16: String?,
    @ColumnInfo(name = "str_measure_17") val strMeasure17: String?,
    @ColumnInfo(name = "str_measure_18") val strMeasure18: String?,
    @ColumnInfo(name = "str_measure_19") val strMeasure19: String?,
    @ColumnInfo(name = "str_measure_20") val strMeasure20: String?,
    @ColumnInfo(name = "str_source") val strSource: String?,
    @ColumnInfo(name = "str_image_source") val strImageSource: String?,
    @ColumnInfo(name = "str_creative_commons_confirmed") val strCreativeCommonsConfirmed: String?,
    @ColumnInfo(name = "date_modified") val dateModified: String?,
) {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
