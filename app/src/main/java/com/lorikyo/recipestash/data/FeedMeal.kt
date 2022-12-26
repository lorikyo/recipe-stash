package com.lorikyo.recipestash.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feed_meal")
data class FeedMeal(
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
    @ColumnInfo(name = "str_source") val strSource: String?,
    @ColumnInfo(name = "str_image_source") val strImageSource: String?,
    @ColumnInfo(name = "str_creative_commons_confirmed") val strCreativeCommonsConfirmed: String?,
    @ColumnInfo(name = "date_modified") val dateModified: String?,
) {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
