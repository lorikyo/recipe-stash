package com.lorikyo.recipestash.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.lorikyo.recipestash.models.MealDto
import com.lorikyo.recipestash.models.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MealListViewModel @Inject constructor(private val mealRepository: MealRepository) : ViewModel() {

    lateinit var meals: Flow<PagingData<MealDto>>

    fun searchMeals() {
        meals = mealRepository.searchMeals().cachedIn(viewModelScope)
    }

}