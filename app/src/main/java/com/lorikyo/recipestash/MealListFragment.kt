package com.lorikyo.recipestash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.lorikyo.recipestash.adapters.MealListAdapter
import com.lorikyo.recipestash.databinding.FragmentMealListBinding
import com.lorikyo.recipestash.viewmodels.MealListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealListFragment : Fragment() {

    private val viewModel: MealListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMealListBinding.inflate(inflater, container, false)
        val adapter = MealListAdapter()
        binding.mealList.adapter = adapter

        viewModel.getMeals()
        viewModel.meals.observe(this.viewLifecycleOwner){items ->
            items.let{
                adapter.submitList(it)
            }
        }

        return binding.root
    }

}