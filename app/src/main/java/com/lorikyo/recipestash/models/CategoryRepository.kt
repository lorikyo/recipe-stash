package com.lorikyo.recipestash.models

import com.lorikyo.recipestash.api.MealDBService
import com.lorikyo.recipestash.data.Category
import com.lorikyo.recipestash.data.CategoryDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryRepository @Inject constructor(private val categoryDao: CategoryDao, private val mealDBService: MealDBService) {

    fun getAllCategories(): Flow<List<CategoryDto>> {
        return categoryDao.getAllCategories().map {
            it.map {
                CategoryDto(
                    strCategory = it.strCategory,
                )
            }
        }
    }

    suspend fun refreshCategories() {
        withContext(Dispatchers.IO) {
            val categories = mealDBService.listAllCategories().meals.map {
                Category(
                    strCategory = it.strCategory,
                )
            }

            categoryDao.insertAll(categories)
        }
    }
}