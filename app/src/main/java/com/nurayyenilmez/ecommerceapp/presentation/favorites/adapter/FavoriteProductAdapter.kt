package com.nurayyenilmez.ecommerceapp.presentation.favorites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nurayyenilmez.ecommerceapp.data.model.ProductListUi
import com.nurayyenilmez.ecommerceapp.databinding.FavoriteItemBinding

class FavoriteProductAdapter:RecyclerView.Adapter<FavoriteViewHolder>() {

    val item= mutableListOf<ProductListUi>()

    private var onFavoriteDeleteClickListener:((String) ->Unit)?= null

    fun setOnFavoriteDeleteClickListener( onFavoriteDeleteClickListener:((String)->Unit)?){
        this. onFavoriteDeleteClickListener= onFavoriteDeleteClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(FavoriteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            ,onFavoriteDeleteClickListener)

    }

    override fun getItemCount()=item.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(item[position])
    }

    fun updateFavoriteProduct(newItem: List<ProductListUi>){
        item.clear()
        item.addAll(newItem)
        notifyDataSetChanged()
    }


}