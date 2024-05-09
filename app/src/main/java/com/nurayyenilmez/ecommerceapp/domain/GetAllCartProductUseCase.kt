package com.nurayyenilmez.ecommerceapp.domain

import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.data.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCartProductUseCase @Inject constructor(private val productRepository: ProductRepository) {

    suspend operator fun invoke(): Flow<List<ProductUi>> {
        return productRepository.getAllCartProduct()
    }
}