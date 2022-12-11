package com.lorikyo.recipestash.models

import com.lorikyo.recipestash.api.MealDBService
import com.lorikyo.recipestash.data.Area
import com.lorikyo.recipestash.data.AreaDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AreaRepository @Inject constructor(private val areaDao: AreaDao, private val mealDBService: MealDBService) {

    fun getAllAreas(): Flow<List<AreaDto>> {
        return areaDao.getAllAreas().map {
            it.map {
                AreaDto(
                    strArea = it.strArea,
                )
            }
        }
    }

    suspend fun refreshAreas() {
        withContext(Dispatchers.IO) {
            val areas = mealDBService.listAllAreas().meals.map {
                Area(
                    strArea = it.strArea,
                )
            }

            areaDao.insertAll(areas)
        }
    }
}