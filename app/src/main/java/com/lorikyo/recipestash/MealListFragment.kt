package com.lorikyo.recipestash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.lorikyo.recipestash.adapters.MealListAdapter
import com.lorikyo.recipestash.databinding.FragmentMealListBinding
import com.lorikyo.recipestash.viewmodels.MealListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealListFragment : Fragment() {

    lateinit var binding: FragmentMealListBinding
    private val viewModel: MealListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMealListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.searchMeals()
        val adapter = MealListAdapter()
        binding.mealList.adapter = adapter
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.meals.collectLatest {
                    adapter.submitData(it)
                }
            }
        }
    }

}