package com.nurayyenilmez.ecommerceapp.data.source.remote

import com.nurayyenilmez.ecommerceapp.data.remote.dto.ProductsResponse

import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val productsApi: ProductsApi) :
    RemoteDataSource {


    override suspend fun getAllCategories():List<String> {
       return productsApi.getAllCategories()
    }

    override suspend fun getAllProduct(): List<ProductsResponse> {
       return productsApi.getAllProduct()
    }

    override suspend fun getSingleProduct(id: String): ProductsResponse{
        return productsApi.getSingleProduct(id)
    }

    override suspend fun singleCategory(category: String): List<ProductsResponse> {
        return productsApi.singleCategory(category)
    }
}