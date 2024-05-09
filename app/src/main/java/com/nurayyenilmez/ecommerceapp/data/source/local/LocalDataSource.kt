package com.nurayyenilmez.ecommerceapp.data.source.local

import androidx.room.Query
import androidx.room.Update
import com.nurayyenilmez.ecommerceapp.data.local.entity.CartProductEntity
import com.nurayyenilmez.ecommerceapp.data.local.entity.FavoriteProductEntity
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import kotlinx.coroutines.flow.Flow


interface LocalDataSource {

    fun getAllFavoriteProduct(): Flow<List<FavoriteProductEntity>>

    suspend fun addFavoriteProduct(favoriteProductEntity: FavoriteProductEntity)

    suspend fun deleteFavoriteProduct(favoriteProductEntity: FavoriteProductEntity)


    fun getAllCartProduct():Flow<List<CartProductEntity>>

    suspend fun addCartProduct(cartProductEntity: CartProductEntity)

    suspend fun deleteCartProduct(cartProductEntity: CartProductEntity)

    suspend fun deleteAllCart()

    suspend fun updateCartProduct(cartProductEntity: CartProductEntity)

}