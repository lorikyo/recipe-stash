package com.lorikyo.recipestash

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lorikyo.recipestash.databinding.FragmentCreateRecipeBinding
import com.lorikyo.recipestash.viewmodels.CreateRecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateRecipeFragment: Fragment() {

    lateinit var binding: FragmentCreateRecipeBinding
    private val viewModel: CreateRecipeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCreateRecipeBinding.inflate(inflater, container, false)
        (activity as AppCompatActivity).setSupportActionBar(binding.topAppBar)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.topAppBar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

}