package com.nurayyenilmez.ecommerceapp.presentation.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nurayyenilmez.ecommerceapp.databinding.CategoryItemBinding

import com.nurayyenilmez.ecommerceapp.presentation.home.adapter.CategoryAdapter
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
//
@AndroidEntryPoint
class CategoryFragment:Fragment() {

    private lateinit var binding:CategoryItemBinding
   override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=
          CategoryItemBinding.inflate(LayoutInflater.from(requireContext()),
                null, false)
         return binding.root

    }

}