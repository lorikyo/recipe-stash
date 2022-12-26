package com.lorikyo.recipestash

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.lorikyo.recipestash.databinding.FragmentFeedMealBinding
import com.lorikyo.recipestash.viewmodels.FeedMealViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedMealFragment : Fragment() {

    lateinit var binding: FragmentFeedMealBinding
    private val viewModel: FeedMealViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedMealBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getFeedMeal()
        viewModel.feedMeal.observe(this.viewLifecycleOwner) { meatDto ->
            meatDto?.let {
                binding.meal = meatDto
                binding.sectionIngredients.removeViews(1, binding.sectionIngredients.childCount - 1)
                meatDto.ingredientMeasures.forEach { ingredientMeasureDto ->
                    val ingredientMeasureView = layoutInflater.inflate(R.layout.ingredient, binding.sectionIngredients, false)
                    ingredientMeasureView.findViewById<TextView>(R.id.name).text = ingredientMeasureDto.name
                    ingredientMeasureView.findViewById<TextView>(R.id.measure).text = ingredientMeasureDto.measure
                    binding.sectionIngredients.addView(ingredientMeasureView)
                }

                var iconId: Int
                var isEnabled: Boolean
                if(it.isAddedToStash == true) {
                    iconId = R.drawable.ic_baseline_check_24
                    isEnabled = false
                } else {
                    iconId = R.drawable.ic_baseline_add_24
                    isEnabled = true
                }
                val addedToStashDrawable = requireContext().resources.getDrawable(iconId, requireContext().theme)
                binding.fabAddToStash.setImageDrawable(addedToStashDrawable)
                binding.fabAddToStash.isEnabled = isEnabled
            }
        }

        binding.fabAddToStash.setOnClickListener {
            viewModel.addMealToStash(it)
            val addedToStashDrawable = requireContext().resources.getDrawable(R.drawable.ic_baseline_check_24, requireContext().theme)
            binding.fabAddToStash.setImageDrawable(addedToStashDrawable)
            binding.fabAddToStash.isEnabled = false
        }

        binding.button.setOnClickListener {
            viewModel.refreshMeal()
        }
    }

}