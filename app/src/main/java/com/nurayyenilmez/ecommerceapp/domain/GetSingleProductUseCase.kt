package com.nurayyenilmez.ecommerceapp.domain

import com.nurayyenilmez.ecommerceapp.common.ResponseState
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi

import com.nurayyenilmez.ecommerceapp.data.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetSingleProductUseCase @Inject constructor(private val productRepository: ProductRepository){

    suspend operator fun invoke( id :String) : Flow<ResponseState<ProductUi>>{
        return productRepository.getSingleProduct(id)
    }
}