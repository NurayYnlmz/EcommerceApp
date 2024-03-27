package com.nurayyenilmez.ecommerceapp.presentation.home.adapter

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.nurayyenilmez.ecommerceapp.R
import com.nurayyenilmez.ecommerceapp.common.addCurrencySign
import com.nurayyenilmez.ecommerceapp.databinding.ProductItemBinding
import com.nurayyenilmez.ecommerceapp.presentation.home.UiProduct
import com.squareup.picasso.Picasso

class ProductViewHolder(private val binding:ProductItemBinding,
                        private val onProductItemClickListener: ((String) -> Unit)?,
)
    :RecyclerView.ViewHolder(binding.root) {


    fun bind(item:UiProduct){
        with(binding){
            productName.text=item.title
            price.text=item.price.toString().addCurrencySign()
            Picasso.get().load(item.image).into(productImage)
            root.setOnClickListener {
                onProductItemClickListener?.invoke(item.id.toString())

            }


            }


        }

    }
