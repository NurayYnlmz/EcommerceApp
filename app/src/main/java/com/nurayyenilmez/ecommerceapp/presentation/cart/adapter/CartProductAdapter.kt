package com.nurayyenilmez.ecommerceapp.presentation.cart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.databinding.CartItemBinding
import com.nurayyenilmez.ecommerceapp.databinding.FavoriteItemBinding
import com.nurayyenilmez.ecommerceapp.presentation.favorites.adapter.FavoriteViewHolder

class CartProductAdapter:RecyclerView.Adapter<CartProductViewHolder>() {
    val item= mutableListOf<ProductUi>()

    private var onCartDeleteClickListener:((String) ->Unit)?= null



    fun setOnCartDeleteClickListener( onCartDeleteClickListener:((String)->Unit)?){
        this. onCartDeleteClickListener= onCartDeleteClickListener
    }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartProductViewHolder {
        return CartProductViewHolder(CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false),
        onCartDeleteClickListener,)
    }

    override fun getItemCount()=item.size

    override fun onBindViewHolder(holder: CartProductViewHolder, position: Int) {
       holder.bind(item[position])
    }
    fun updateCartProduct(newItem: List<ProductUi>){
        item.clear()
        item.addAll(newItem)
        notifyDataSetChanged()
    }
}