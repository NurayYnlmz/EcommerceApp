package com.nurayyenilmez.ecommerceapp.data.repository

import kotlinx.coroutines.flow.Flow

interface ProductRepository {
      suspend fun getAllCategories()
      suspend fun getAllProduct()
      suspend fun getSingleCategory(category:String)
}
