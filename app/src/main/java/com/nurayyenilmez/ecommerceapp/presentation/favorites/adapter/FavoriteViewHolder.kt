package com.nurayyenilmez.ecommerceapp.presentation.favorites.adapter

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.nurayyenilmez.ecommerceapp.common.addCurrencySign
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.databinding.FavoriteItemBinding
import com.squareup.picasso.Picasso

class FavoriteViewHolder(private val binding:FavoriteItemBinding,
                         private val onFavoriteDeleteClickListener: ((String) -> Unit)?)
    :RecyclerView.ViewHolder(binding.root) {

    fun bind(item:ProductUi) {
        with(binding) {
            favoriteProductName.text = item.title
            favoriteProductPrice.text = item.price.toString().addCurrencySign()
            ratingBar.rating= item.rating?.rate?.toFloat()!!
            Picasso.get().load(item.image).into(favoriteProductImage)
            binding.deleteFavorite.setOnClickListener {
                onFavoriteDeleteClickListener?.invoke(item.id.toString())
            }

        }
    }
}