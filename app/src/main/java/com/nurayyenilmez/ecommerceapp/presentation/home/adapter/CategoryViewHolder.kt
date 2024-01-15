package com.nurayyenilmez.ecommerceapp.presentation.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.nurayyenilmez.ecommerceapp.databinding.CategoryItemBinding
import com.nurayyenilmez.ecommerceapp.presentation.home.UiCategory

class CategoryViewHolder (private val binding: CategoryItemBinding):RecyclerView.ViewHolder
    (binding.root){

     fun bind(categories:UiCategory){
    with(binding){
        categoryName.text="Text Vieew"
    }
     }

}
