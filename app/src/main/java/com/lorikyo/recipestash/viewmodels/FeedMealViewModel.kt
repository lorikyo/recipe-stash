package com.lorikyo.recipestash.viewmodels

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.material.snackbar.Snackbar
import com.lorikyo.recipestash.R
import com.lorikyo.recipestash.models.MealDto
import com.lorikyo.recipestash.models.FeedMealRepository
import com.lorikyo.recipestash.models.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedMealViewModel @Inject constructor(
    private val feedMealRepository: FeedMealRepository,
    private val mealRepository: MealRepository
) : ViewModel() {

    lateinit var feedMeal: LiveData<MealDto?>

    fun getFeedMeal() {
        viewModelScope.launch {
            feedMeal = feedMealRepository.getFeedMeal().asLiveData()
        }
    }

    fun refreshMeal() {
        viewModelScope.launch {
            feedMealRepository.refreshFeedMeal()
        }
    }

    fun addMealToStash(view: View) {
        feedMeal.value?.let {
            viewModelScope.launch {
                mealRepository.addMealToStash(it)
                val snackbar = Snackbar.make(view, R.string.added_to_stash, Snackbar.LENGTH_LONG)
                snackbar.show()
            }
        }
        getFeedMeal()
    }

}