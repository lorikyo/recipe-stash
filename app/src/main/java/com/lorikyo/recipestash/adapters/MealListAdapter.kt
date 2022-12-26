package com.lorikyo.recipestash.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.lorikyo.recipestash.databinding.MealViewholderBinding
import com.lorikyo.recipestash.models.MealDto

class MealListAdapter : PagingDataAdapter<MealDto, MealListAdapter.MealViewHolder>(MealDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return MealViewHolder(
            MealViewholderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = getItem(position)
        if (meal != null) {
            holder.bind(meal)
        }
    }

    class MealViewHolder(private val binding: MealViewholderBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.meal?.idMeal?.let { mealId ->
                    navigateToMeal(mealId, view)
                }
            }
        }

        private fun navigateToMeal(mealId: String, view: View) {
        }

        fun bind(mealDto: MealDto) {
            with(binding) {
                meal = mealDto
                executePendingBindings()
            }
        }

    }
}

private class MealDiffCallback : DiffUtil.ItemCallback<MealDto>() {

    override fun areItemsTheSame(oldItem: MealDto, newItem: MealDto): Boolean {
        return oldItem.idMeal == newItem.idMeal
    }

    override fun areContentsTheSame(oldItem: MealDto, newItem: MealDto): Boolean {
        return oldItem.idMeal == newItem.idMeal
    }
}