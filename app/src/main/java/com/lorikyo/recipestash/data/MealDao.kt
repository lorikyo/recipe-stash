package com.lorikyo.recipestash.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {

    @Query("SELECT * FROM meal ORDER BY datetime_modified DESC LIMIT :limit OFFSET :offset")
    suspend fun getMeals(limit: Int, offset: Int): List<Meal>

    @Query("SELECT * FROM meal WHERE id_meal = :idMeal")
    suspend fun getMealByIdMeal(idMeal: String): Meal

    @Transaction
    @Query("SELECT * FROM meal WHERE id = :id")
    fun getMealIngredientMeasures(id: Long): Flow<MealAndIngredientMeasures>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(meal: Meal): Long

}