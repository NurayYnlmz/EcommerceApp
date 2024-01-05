package com.nurayyenilmez.ecommerceapp.data.repository

import com.nurayyenilmez.ecommerceapp.common.ResponseState
import com.nurayyenilmez.ecommerceapp.data.model.ProductList
import com.nurayyenilmez.ecommerceapp.data.remote.dto.ProductsResponse
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
      suspend fun getAllCategories():Flow<ResponseState<ProductsResponse>>
      suspend fun getAllProduct():Flow<ResponseState<List<ProductList>>>
      suspend fun getSingleCategory(category:String)


}
