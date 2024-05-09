package com.nurayyenilmez.ecommerceapp.presentation.cart.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nurayyenilmez.ecommerceapp.R
import com.nurayyenilmez.ecommerceapp.common.addCurrencySign
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.databinding.CartItemBinding
import com.squareup.picasso.Picasso

class CartProductViewHolder(
    private val binding: CartItemBinding,
    private val onCartDeleteClickListener: ((String) -> Unit)?,
    private var onIncreaseClick: ((ProductUi) -> Unit)?,
    private var onDecreaseClick: ((ProductUi) -> Unit)?


) : RecyclerView.ViewHolder(binding.root) {

    fun bind(productUi: ProductUi) {
        with(binding) {
            cartProductName.text = productUi.title
            cartProductPrice.text = productUi.price.toString().addCurrencySign()
            amount.text = productUi.productQuantity.toString()
            Picasso.get().load(productUi.image).into(cartProductImage)

            binding.deleteCart.setOnClickListener {
                onCartDeleteClickListener?.invoke(productUi.id.toString())
            }


            if (productUi.productQuantity == 1) {
                binding.decrease.setImageResource(R.drawable.unclickable_minus)
            } else {
                binding.decrease.setImageResource(R.drawable.remove)
            }
            binding.Increase.setOnClickListener {
                if (productUi.productQuantity == 1 || (productUi.productQuantity > 1)) {
                    onIncreaseClick?.let { it1 -> it1(productUi) }
                    productUi.productQuantity++
                    amount.text = productUi.productQuantity.toString()
                }
            }
            binding.decrease.setOnClickListener {
                if (productUi.productQuantity != 1) {
                    onDecreaseClick?.let { it1 -> it1(productUi) }
                    productUi.productQuantity--
                    amount.text = productUi.productQuantity.toString()
                    productUi.productQuantity * productUi.price!!

                } else {
                    binding.decrease.isSelected =false

                }
            }
        }
    }
}



