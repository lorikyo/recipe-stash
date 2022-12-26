package com.lorikyo.recipestash.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FeedMealIngredientMeasureDao {

    @Query("DELETE FROM feed_meal_ingredient_measure")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(feedMealIngredientMeasures: List<FeedMealIngredientMeasure>)
}