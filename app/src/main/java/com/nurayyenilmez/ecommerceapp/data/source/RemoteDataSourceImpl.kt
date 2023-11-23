package com.nurayyenilmez.ecommerceapp.data.source

import com.nurayyenilmez.ecommerceapp.data.model.ProductsResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val productsApi: ProductsApi) : RemoteDataSource {


    override suspend fun getAllCategories(): ArrayList<String> {
       return productsApi.getAllCategories()
    }

    override suspend fun getAllProduct(): Response<ProductsResponse> {
       return productsApi.getAllProduct()
    }

    override suspend fun singleCategory(category: String): Response<ProductsResponse> {
        return productsApi.singleCategory(category)
    }
}