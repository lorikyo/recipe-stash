package com.lorikyo.recipestash.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Area::class, Category::class, IngredientMeasure::class, Meal::class, FeedMeal::class, FeedMealIngredientMeasure::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "recipestash-db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun areaDao(): AreaDao

    abstract fun categoryDao(): CategoryDao

    abstract fun ingredientMeasureDao(): IngredientMeasureDao

    abstract fun mealDao(): MealDao

    abstract fun feedMealIngredientMeasureDao(): FeedMealIngredientMeasureDao

    abstract fun feedMealDao(): FeedMealDao

}