package com.lorikyo.recipestash.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FeedMealDao {

    @Query("SELECT * FROM feed_meal")
    fun getFeedMeal(): Flow<List<FeedMeal>>

    @Transaction
    @Query("SELECT * FROM feed_meal LIMIT 1")
    fun getFeedMealAndFeedMealIngredientMeasures(): Flow<FeedMealAndFeedMealIngredientMeasures>

    @Query("DELETE FROM feed_meal")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(feedMeal: FeedMeal): Long
}