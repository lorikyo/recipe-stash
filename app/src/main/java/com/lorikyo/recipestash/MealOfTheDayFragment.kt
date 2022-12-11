package com.lorikyo.recipestash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.lorikyo.recipestash.databinding.FragmentMealOfTheDayBinding
import com.lorikyo.recipestash.viewmodels.MealOfTheDayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealOfTheDayFragment : Fragment() {

    private val viewModel: MealOfTheDayViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMealOfTheDayBinding.inflate(inflater, container, false)
        viewModel.getMealOfTheDay()

        viewModel.meal.observe(this.viewLifecycleOwner) { item ->
            item ?: viewModel.refreshMealOfTheDay()
            item?.let {
                binding.meal = item
                binding.sectionIngredients.removeViews(1, binding.sectionIngredients.childCount - 1)
                if (!item?.strIngredient1.isNullOrEmpty()) {
                    val view = inflater.inflate(R.layout.ingredient, binding.sectionIngredients, true)
                    val textView = view.findViewById<TextView>(R.id.ingredient)
                    textView.text = item?.strIngredient1
                }
            }
        }

        binding.button.setOnClickListener {
            viewModel.refreshMealOfTheDay()
        }

        return binding?.root
    }

}