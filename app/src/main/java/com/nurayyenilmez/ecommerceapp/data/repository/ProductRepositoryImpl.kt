package com.nurayyenilmez.ecommerceapp.data.repository


import com.nurayyenilmez.ecommerceapp.common.ResponseState
import com.nurayyenilmez.ecommerceapp.common.mapTo
import com.nurayyenilmez.ecommerceapp.common.toCartProduct
import com.nurayyenilmez.ecommerceapp.common.toCartProductEntity
import com.nurayyenilmez.ecommerceapp.common.toFavoriteProduct
import com.nurayyenilmez.ecommerceapp.common.toFavoriteProductEntity
import com.nurayyenilmez.ecommerceapp.common.toProductList
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.data.source.local.LocalDataSource
import com.nurayyenilmez.ecommerceapp.data.source.remote.RemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : ProductRepository {

    override suspend fun getAllProduct(): Flow<ResponseState<List<ProductUi>>> {
        return flow {
            emit(ResponseState.Loading)
            val response = remoteDataSource.getAllProduct()
            emit(ResponseState.Success(response.map { it.toProductList() }))
        }.catch { ResponseState.Error(it.message.orEmpty()) }

    }

    override suspend fun getSingleProduct(id: String): Flow<ResponseState<ProductUi>> {
        return flow {
            emit(ResponseState.Loading)
            val singleResponse = remoteDataSource.getSingleProduct(id)
            emit(ResponseState.Success(singleResponse.mapTo { it.toFavoriteProduct() }))
        }.catch { ResponseState.Error(it.message.orEmpty()) }
    }

    override suspend fun getAllFavoritesProduct(): Flow<List<ProductUi>> {
        return localDataSource.getAllFavoriteProduct().map {
            it.map { favorite -> favorite.toFavoriteProduct() }
        }
    }

    override suspend fun addFavorites(productListUi: ProductUi) {
        localDataSource.addFavoriteProduct(productListUi.toFavoriteProductEntity())
    }

    override suspend fun deleteFavorites(productListUi: ProductUi) {
        localDataSource.deleteFavoriteProduct(productListUi.toFavoriteProductEntity())
    }

    override fun getAllCartProduct(): Flow<List<ProductUi>> {
        return localDataSource.getAllCartProduct().map { it.map { cart -> cart.toCartProduct() } }
    }

    override suspend fun addCartProduct(cartProductUi: ProductUi) {
        localDataSource.addCartProduct(cartProductUi.toCartProductEntity())
    }

    override suspend fun deleteCartProduct(cartProductUi: ProductUi) {
        localDataSource.deleteCartProduct(cartProductUi.toCartProductEntity())
    }

    override suspend fun deleteAllCart() {
        localDataSource.deleteAllCart()
    }

    override suspend fun updateCartProduct(productUi: ProductUi) {
        localDataSource.updateCartProduct(productUi.toCartProductEntity())

    }

}



