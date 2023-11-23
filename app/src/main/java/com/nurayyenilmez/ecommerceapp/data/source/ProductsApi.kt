package com.nurayyenilmez.ecommerceapp.data.source

import com.nurayyenilmez.ecommerceapp.data.model.ProductsResponse

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsApi {

    @GET("products/categories")
    suspend fun getAllCategories():ArrayList<String>

    @GET("products")
    suspend fun getAllProduct():Response<ProductsResponse>

    @GET("/products/category/{category}")
    suspend fun singleCategory(@Path("category") category:String):Response<ProductsResponse>
}
