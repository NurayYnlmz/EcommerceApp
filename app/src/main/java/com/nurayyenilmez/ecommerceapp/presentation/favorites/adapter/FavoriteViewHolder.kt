package com.nurayyenilmez.ecommerceapp.presentation.favorites.adapter

import androidx.recyclerview.widget.RecyclerView
import com.nurayyenilmez.ecommerceapp.common.addCurrencySign
import com.nurayyenilmez.ecommerceapp.data.model.ProductListUi
import com.nurayyenilmez.ecommerceapp.databinding.FavoriteItemBinding
import com.squareup.picasso.Picasso

class FavoriteViewHolder(private val binding:FavoriteItemBinding,
                         private val onFavoriteDeleteClickListener: ((String) -> Unit)?)
    :RecyclerView.ViewHolder(binding.root) {


    fun bind(item:ProductListUi) {
        with(binding) {
            favoriteProductName.text = item.description
            favoriteProductPrice.text = item.price.toString().addCurrencySign()
            ratingBar.rating= item.rating?.rate?.toFloat()!!
            Picasso.get().load(item.image).into(favoriteProductImage)
            binding.deleteFavorite.setOnClickListener {
                onFavoriteDeleteClickListener?.invoke(item.id.toString())
            }
        }
    }
}