package com.nurayyenilmez.ecommerceapp.data.repository

import com.nurayyenilmez.ecommerceapp.common.ResponseState
import com.nurayyenilmez.ecommerceapp.data.model.ProductListUi
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

      suspend fun getAllProduct():Flow<ResponseState<List<ProductListUi>>>
       suspend fun getSingleProduct(id:String):Flow<ResponseState<ProductListUi>>

       suspend fun getAllFavoritesProduct():Flow<List<ProductListUi>>
       suspend fun addFavorites(productListUi: ProductListUi)
       suspend fun deleteFavorites(productListUi: ProductListUi)

}
