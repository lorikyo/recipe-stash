package com.lorikyo.recipestash.data

import androidx.room.*

@Entity(
    tableName = "feed_meal_ingredient_measure",
    foreignKeys = [ForeignKey(entity = FeedMeal::class, parentColumns = ["id"], childColumns = ["meal_id"])],
    indices = [Index(value = ["meal_id"])],
)
data class FeedMealIngredientMeasure(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "measure") val measure: String?,
    @ColumnInfo(name = "meal_id") val mealId: Long,
) {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
