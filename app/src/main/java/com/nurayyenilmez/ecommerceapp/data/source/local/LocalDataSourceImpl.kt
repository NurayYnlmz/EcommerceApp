package com.nurayyenilmez.ecommerceapp.data.source.local

import com.nurayyenilmez.ecommerceapp.data.local.CartDao
import com.nurayyenilmez.ecommerceapp.data.local.FavoriteDao
import com.nurayyenilmez.ecommerceapp.data.local.entity.CartProductEntity
import com.nurayyenilmez.ecommerceapp.data.local.entity.FavoriteProductEntity
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val favoriteDao: FavoriteDao,
      private val cartDao: CartDao
) : LocalDataSource {
    override fun getAllFavoriteProduct(): Flow<List<FavoriteProductEntity>> {
        return favoriteDao.getAllFavoriteProduct()
    }

    override suspend fun addFavoriteProduct(favoriteProductEntity: FavoriteProductEntity) {
        favoriteDao.addFavoriteProduct(favoriteProductEntity)

    }

    override suspend fun deleteFavoriteProduct(favoriteProductEntity: FavoriteProductEntity) {
        favoriteDao.deleteFavoriteProduct(favoriteProductEntity)
    }

    override fun getAllCartProduct(): Flow<List<CartProductEntity>> {
       return cartDao.getAllCartProduct()

    }


    override suspend fun addCartProduct(cartProductEntity: CartProductEntity) {
       cartDao.addCartProduct(cartProductEntity)
    }

    override suspend fun deleteCartProduct(cartProductEntity: CartProductEntity) {
      cartDao.deleteCartProduct(cartProductEntity)
    }



}

