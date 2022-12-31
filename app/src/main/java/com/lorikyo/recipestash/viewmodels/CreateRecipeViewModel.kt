package com.lorikyo.recipestash.viewmodels

import androidx.lifecycle.ViewModel
import com.lorikyo.recipestash.models.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateRecipeViewModel @Inject constructor(private val mealRepository: MealRepository) : ViewModel() {
}