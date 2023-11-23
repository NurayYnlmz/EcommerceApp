package com.nurayyenilmez.ecommerceapp.data.repository

import com.nurayyenilmez.ecommerceapp.data.source.RemoteDataSource
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) : ProductRepository {

    override suspend fun getAllCategories() {
        TODO("Not yet implemented")
    }

    override suspend fun getAllProduct() {
        TODO("Not yet implemented")
    }

    override suspend fun getSingleCategory(category: String) {
        TODO("Not yet implemented")
    }

}