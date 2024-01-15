package com.nurayyenilmez.ecommerceapp.presentation.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nurayyenilmez.ecommerceapp.databinding.CategoryItemBinding
import com.nurayyenilmez.ecommerceapp.presentation.home.UiCategory


class CategoryAdapter :RecyclerView.Adapter<CategoryViewHolder>() {

    private val categories = mutableListOf<UiCategory>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateCategory(newItem:List<UiCategory>){
        categories.clear()
        categories.addAll(newItem)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
    return CategoryViewHolder(CategoryItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount()=categories.size



    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
       holder.bind(categories[position])
    }


}