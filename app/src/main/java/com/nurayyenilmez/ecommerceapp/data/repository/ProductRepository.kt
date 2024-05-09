package com.nurayyenilmez.ecommerceapp.data.repository

import com.nurayyenilmez.ecommerceapp.common.ResponseState
import com.nurayyenilmez.ecommerceapp.data.local.entity.CartProductEntity
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getAllProduct(): Flow<ResponseState<List<ProductUi>>>
    suspend fun getSingleProduct(id: String): Flow<ResponseState<ProductUi>>

    suspend fun getAllFavoritesProduct(): Flow<List<ProductUi>>
    suspend fun addFavorites(productListUi: ProductUi)
    suspend fun deleteFavorites(productListUi: ProductUi)

    fun getAllCartProduct(): Flow<List<ProductUi>>

    suspend fun addCartProduct(ProductUi: ProductUi)

    suspend fun deleteCartProduct(ProductUi: ProductUi)

    suspend fun deleteAllCart()

    suspend fun updateCartProduct(productUi: ProductUi)


}
