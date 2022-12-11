package com.lorikyo.recipestash.viewmodels

import androidx.lifecycle.*
import com.lorikyo.recipestash.data.Meal
import com.lorikyo.recipestash.models.MealOfTheDayRepository
import com.lorikyo.recipestash.models.MealDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealOfTheDayViewModel @Inject constructor(private val mealOfTheDayRepository: MealOfTheDayRepository) : ViewModel()  {

    lateinit var meal: LiveData<MealDto?>

    fun getMealOfTheDay() {
        meal = mealOfTheDayRepository.getMealOfTheDay().asLiveData()
//        viewModelScope.launch {
//            mealOfTheDayRepository.getMealOfTheDay().collect{
//                it?.also {
//                    meal = it
//                } ?: {
//                    mealOfTheDayRepository.refreshMealOfTheDay()
//                }
//            }
//        }
    }

    fun refreshMealOfTheDay() {
        viewModelScope.launch {
            mealOfTheDayRepository.refreshMealOfTheDay()
        }
    }

}