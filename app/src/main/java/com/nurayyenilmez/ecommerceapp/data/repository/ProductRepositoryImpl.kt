package com.nurayyenilmez.ecommerceapp.data.repository


import com.nurayyenilmez.ecommerceapp.common.ResponseState
import com.nurayyenilmez.ecommerceapp.common.toProductList

import com.nurayyenilmez.ecommerceapp.data.model.ProductList
import com.nurayyenilmez.ecommerceapp.data.remote.dto.ProductsResponse
import com.nurayyenilmez.ecommerceapp.data.source.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow


import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource) : ProductRepository {


    override suspend fun getAllCategories():Flow<ResponseState<ProductsResponse>> {
        return flow {

        }
    }

    override suspend fun getAllProduct():Flow<ResponseState<List<ProductList>>>{
        return flow {
            emit(ResponseState.Loading)
            val response=remoteDataSource.getAllProduct()
            emit(ResponseState.Success(response.map {it.toProductList() }))
        }.catch { ResponseState.Error(it.message.orEmpty()) }

        }
    override suspend fun getSingleCategory(category: String) {
        TODO("Not yet implemented")
    }

}

