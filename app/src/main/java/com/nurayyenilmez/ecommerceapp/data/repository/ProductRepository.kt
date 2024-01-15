package com.nurayyenilmez.ecommerceapp.data.repository

import com.nurayyenilmez.ecommerceapp.common.ResponseState
import com.nurayyenilmez.ecommerceapp.data.model.CategoryUi
import com.nurayyenilmez.ecommerceapp.data.model.ProductListUi
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
      suspend fun getAllCategories():Flow<ResponseState<List<CategoryUi>>>
      suspend fun getAllProduct():Flow<ResponseState<List<ProductListUi>>>
      suspend fun getSingleCategory(category:String):Flow<ResponseState<List<CategoryUi>>>


}
