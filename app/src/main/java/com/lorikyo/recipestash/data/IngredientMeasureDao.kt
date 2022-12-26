package com.lorikyo.recipestash.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface IngredientMeasureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(ingredientMeasures: List<IngredientMeasure>)
}