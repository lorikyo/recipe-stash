package com.lorikyo.recipestash.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.lorikyo.recipestash.models.MealRepository
import com.lorikyo.recipestash.models.MealDto
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealListViewModel @Inject constructor(private val mealRepository: MealRepository) : ViewModel() {

    private val _meals = MutableLiveData<List<MealDto>>()
    val meals: LiveData<List<MealDto>> = _meals

    fun getMeals() {
        val mealList = mealRepository.getMeals().asLiveData().value
        _meals.value = mealList
    }

}