package com.nurayyenilmez.ecommerceapp.data.source

import com.nurayyenilmez.ecommerceapp.data.remote.dto.ProductsResponse


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsApi {

    @GET("products/categories")
    suspend fun getAllCategories():List<ProductsResponse>

    @GET("products")
    suspend fun getAllProduct():List<ProductsResponse>

    @GET("/products/category/{category}")
    suspend fun singleCategory(@Path("category") category:String):Response<ProductsResponse>
}
