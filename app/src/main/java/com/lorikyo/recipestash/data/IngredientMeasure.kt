package com.lorikyo.recipestash.data

import androidx.room.*

@Entity(
    tableName = "ingredient_measure",
    foreignKeys = [ForeignKey(entity = Meal::class, parentColumns = ["id"], childColumns = ["meal_id"])],
    indices = [Index(value = ["meal_id"])],
)
data class IngredientMeasure(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "measure") val measure: String?,
    @ColumnInfo(name = "meal_id") val mealId: Long,
) {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
