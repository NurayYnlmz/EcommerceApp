package com.nurayyenilmez.ecommerceapp.presentation.cart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.databinding.CartItemBinding

class CartProductAdapter : RecyclerView.Adapter<CartProductViewHolder>() {


    val item = mutableListOf<ProductUi>()

    private var onCartDeleteClickListener: ((String) -> Unit)? = null
    private var onIncreaseClick: ((ProductUi) -> Unit)? = null
    private var onDecreaseClick: ((ProductUi) -> Unit)? = null

    fun setOnIncreaseClickListener(onIncreaseClick: ((ProductUi) -> Unit)?) {
        this.onIncreaseClick = onIncreaseClick
    }

    fun setOnDecreaseClickListener(onDecreaseClick: ((ProductUi) -> Unit)?) {
        this.onDecreaseClick = onDecreaseClick
    }

    fun setOnCartDeleteClickListener(onCartDeleteClickListener: ((String) -> Unit)?) {
        this.onCartDeleteClickListener = onCartDeleteClickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartProductViewHolder {
        return CartProductViewHolder(
            CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onCartDeleteClickListener, onIncreaseClick, onDecreaseClick
        )
    }

    override fun getItemCount() = item.size

    override fun onBindViewHolder(holder: CartProductViewHolder, position: Int) {
        holder.bind(item[position])
    }

    fun updateCartProduct(newItem: List<ProductUi>) {
        item.clear()
        item.addAll(newItem)
        notifyDataSetChanged()
    }
}