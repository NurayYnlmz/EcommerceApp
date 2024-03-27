package com.nurayyenilmez.ecommerceapp.presentation.cart.adapter

import androidx.recyclerview.widget.RecyclerView
import com.nurayyenilmez.ecommerceapp.common.addCurrencySign
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.databinding.CartItemBinding
import com.squareup.picasso.Picasso

class CartProductViewHolder(private val binding:CartItemBinding,
                            private val onCartDeleteClickListener: ((String) -> Unit)?,

)
    :RecyclerView.ViewHolder(binding.root) {

    fun bind(productUi: ProductUi) {
        with(binding){
            favoriteProductName.text=productUi.title
            favoriteProductPrice.text=productUi.price.toString().addCurrencySign()
            Picasso.get().load(productUi.image).into(favoriteProductImage)
            binding.deleteCart.setOnClickListener {
                onCartDeleteClickListener?.invoke(productUi.id.toString())
            }
        }
    }



}