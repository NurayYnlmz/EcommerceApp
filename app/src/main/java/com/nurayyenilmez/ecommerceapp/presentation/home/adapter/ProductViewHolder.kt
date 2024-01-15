package com.nurayyenilmez.ecommerceapp.presentation.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.nurayyenilmez.ecommerceapp.data.model.ProductListUi
import com.nurayyenilmez.ecommerceapp.databinding.ProductItemBinding
import com.nurayyenilmez.ecommerceapp.presentation.home.UiProduct
import com.squareup.picasso.Picasso

class ProductViewHolder(private val binding:ProductItemBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(item:UiProduct){
        with(binding){
            productName.text=item.title
            price.text=item.price.toString()
            ratingBar.rating= item.rating?.rate?.toFloat()!!
            ratingCount.text=item.rating.count.toString()
            Picasso.get().load(item.image).into(productImage)
        }

    }
}