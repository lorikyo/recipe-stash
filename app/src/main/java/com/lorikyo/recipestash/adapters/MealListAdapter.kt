package com.lorikyo.recipestash.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lorikyo.recipestash.R
import com.lorikyo.recipestash.models.MealDto
import com.lorikyo.recipestash.databinding.ListItemMealBinding

class MealListAdapter: ListAdapter<MealDto, MealListAdapter.ViewHolder>(MealDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_meal,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ListItemMealBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.meal?.idMeal?.let { mealId ->
                    navigateToMeal(mealId, view)
                }
            }
        }

        private fun navigateToMeal(mealId: String, view: View) {
        }

        fun bind(listMeal: MealDto) {
            with(binding){
                meal = listMeal
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