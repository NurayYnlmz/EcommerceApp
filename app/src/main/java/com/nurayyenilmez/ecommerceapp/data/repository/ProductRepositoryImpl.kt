package com.nurayyenilmez.ecommerceapp.data.repository


import com.nurayyenilmez.ecommerceapp.common.ResponseState
import com.nurayyenilmez.ecommerceapp.common.toCategory
import com.nurayyenilmez.ecommerceapp.common.toProductList
import com.nurayyenilmez.ecommerceapp.data.model.CategoryUi

import com.nurayyenilmez.ecommerceapp.data.model.ProductListUi
import com.nurayyenilmez.ecommerceapp.data.source.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow


import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource) : ProductRepository {


    override suspend fun getAllCategories():Flow<ResponseState<List<CategoryUi>>> {
        return flow {
            emit(ResponseState.Loading)
            val allCategoryResponse=remoteDataSource.getAllCategories()
            emit(ResponseState.Success(allCategoryResponse.map { it.toCategory()}))
        }.catch { ResponseState.Error(it.message.orEmpty()) }
    }

    override suspend fun getAllProduct():Flow<ResponseState<List<ProductListUi>>>{
        return flow {
            emit(ResponseState.Loading)
            val response=remoteDataSource.getAllProduct()
            emit(ResponseState.Success(response.map {it.toProductList() }))
        }.catch { ResponseState.Error(it.message.orEmpty()) }

        }
    override suspend fun getSingleCategory(category: String):Flow<ResponseState<List<CategoryUi>>> {

        return flow {
            emit(ResponseState.Loading)

        }
    }

}

