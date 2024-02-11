package com.nurayyenilmez.ecommerceapp.data.source.remote

import com.nurayyenilmez.ecommerceapp.data.remote.dto.ProductsResponse


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsApi {

    @GET("products/categories")
    suspend fun getAllCategories():List<String>

    @GET("products")
    suspend fun getAllProduct():List<ProductsResponse>

    @GET("products/{id}")
    suspend fun getSingleProduct(@Path("id") id:String):ProductsResponse

    @GET("/products/category/{category_name}")
    suspend fun singleCategory(@Path("category_name") category:String):List<ProductsResponse>
}
