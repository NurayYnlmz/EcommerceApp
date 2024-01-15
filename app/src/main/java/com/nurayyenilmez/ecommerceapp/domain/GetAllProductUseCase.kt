package com.nurayyenilmez.ecommerceapp.domain

import com.nurayyenilmez.ecommerceapp.common.ResponseState
import com.nurayyenilmez.ecommerceapp.data.model.ProductListUi
import com.nurayyenilmez.ecommerceapp.data.repository.ProductRepository

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllProductUseCase @Inject constructor(private val productRepository: ProductRepository) {

    suspend operator fun invoke() :Flow<ResponseState<List<ProductListUi>>>{
        return productRepository.getAllProduct()
    }
}