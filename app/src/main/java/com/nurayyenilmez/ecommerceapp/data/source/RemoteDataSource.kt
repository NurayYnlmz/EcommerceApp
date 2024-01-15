package com.nurayyenilmez.ecommerceapp.data.source

import com.nurayyenilmez.ecommerceapp.data.remote.dto.ProductsResponse
import retrofit2.Response
import retrofit2.http.Path


interface RemoteDataSource {

     suspend fun getAllCategories():List<String>

    suspend fun getAllProduct(): List<ProductsResponse>

    suspend fun singleCategory(@Path("category_name") category:String):List<ProductsResponse>
}