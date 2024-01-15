package com.nurayyenilmez.ecommerceapp.presentation.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nurayyenilmez.ecommerceapp.data.model.ProductListUi
import com.nurayyenilmez.ecommerceapp.databinding.ProductItemBinding
import com.nurayyenilmez.ecommerceapp.presentation.home.UiProduct


@SuppressLint("NotifyDataSetChanged")
class AllProductAdapter: RecyclerView.Adapter<ProductViewHolder>() {

    private val items= mutableListOf<UiProduct>()


    fun updateProduct(newItem:List<UiProduct>){
        items.clear()
        items.addAll(newItem)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(ProductItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount()=items.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
       holder.bind(items[position])
    }
}