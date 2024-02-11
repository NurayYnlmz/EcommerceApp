package com.nurayyenilmez.ecommerceapp.data.repository

import com.nurayyenilmez.ecommerceapp.common.ResponseState
import com.nurayyenilmez.ecommerceapp.common.mapTo
import com.nurayyenilmez.ecommerceapp.common.toFavoriteProductEntity
import com.nurayyenilmez.ecommerceapp.common.toProduct
import com.nurayyenilmez.ecommerceapp.common.toProductList
import com.nurayyenilmez.ecommerceapp.data.model.ProductListUi
import com.nurayyenilmez.ecommerceapp.data.source.local.LocalDataSource
import com.nurayyenilmez.ecommerceapp.data.source.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map


import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : ProductRepository {

    override suspend fun getAllProduct():Flow<ResponseState<List<ProductListUi>>>{
        return flow {
            emit(ResponseState.Loading)
            val response=remoteDataSource.getAllProduct()
            emit(ResponseState.Success(response.map {it.toProductList() }))
        }.catch { ResponseState.Error(it.message.orEmpty()) }

        }
    override suspend fun getSingleProduct(id: String): Flow<ResponseState<ProductListUi>> {
         return flow {
             emit(ResponseState.Loading)
             val singleResponse=remoteDataSource.getSingleProduct(id)
             emit(ResponseState.Success(singleResponse.mapTo{ it.toProduct() }))
         }.catch { ResponseState.Error(it.message.orEmpty()) }
    }

    override suspend fun getAllFavoritesProduct():Flow<List<ProductListUi>>{
      return localDataSource.getAllFavoriteProduct().map{it.
      map{ favorite ->favorite.toProduct()} }
      }

      override suspend fun addFavorites(productListUi: ProductListUi) {
         localDataSource.addFavoriteProduct(productListUi.toFavoriteProductEntity())
        }

    override suspend fun deleteFavorites(productListUi: ProductListUi) {
        localDataSource.deleteFavoriteProduct(productListUi.toFavoriteProductEntity())
    }





}

