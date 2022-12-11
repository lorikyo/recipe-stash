package com.lorikyo.recipestash.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MealOfTheDayDao {

    @Query("SELECT * FROM meal_of_the_day")
    fun getMealOfTheDay(): Flow<List<MealOfTheDay>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mealOfTheDay: MealOfTheDay)

    @Query("DELETE FROM meal_of_the_day")
    fun deleteAll()
}