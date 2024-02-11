package com.nurayyenilmez.ecommerceapp.data.source.local

import com.nurayyenilmez.ecommerceapp.data.local.FavoriteDao
import com.nurayyenilmez.ecommerceapp.data.local.entity.FavoriteProductEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor (private val favoriteDao: FavoriteDao) : LocalDataSource {
    override fun getAllFavoriteProduct(): Flow<List<FavoriteProductEntity>> {
       return favoriteDao.getAllFavoriteProduct()
    }

    override suspend fun addFavoriteProduct(favoriteProductEntity: FavoriteProductEntity){
        favoriteDao.addFavoriteProduct(favoriteProductEntity)


    }

    override suspend fun deleteFavoriteProduct(favoriteProductEntity: FavoriteProductEntity){
      favoriteDao.deleteFavoriteProduct(favoriteProductEntity)
    }




}

