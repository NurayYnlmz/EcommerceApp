package com.nurayyenilmez.ecommerceapp.data.source

import com.nurayyenilmez.ecommerceapp.data.model.ProductsResponse
import retrofit2.Response
import retrofit2.http.Path


interface RemoteDataSource {

     suspend fun getAllCategories():ArrayList<String>

    suspend fun getAllProduct(): Response<ProductsResponse>

    suspend fun singleCategory(@Path("category") category:String):Response<ProductsResponse>
}