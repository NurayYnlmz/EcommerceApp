package com.nurayyenilmez.ecommerceapp.data.source.local

import com.nurayyenilmez.ecommerceapp.data.local.entity.FavoriteProductEntity
import kotlinx.coroutines.flow.Flow


interface LocalDataSource {

    fun getAllFavoriteProduct(): Flow<List<FavoriteProductEntity>>

    suspend fun addFavoriteProduct(favoriteProductEntity: FavoriteProductEntity)

    suspend fun deleteFavoriteProduct(favoriteProductEntity: FavoriteProductEntity)




}