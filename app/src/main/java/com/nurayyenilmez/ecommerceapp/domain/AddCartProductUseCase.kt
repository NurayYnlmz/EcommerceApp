package com.nurayyenilmez.ecommerceapp.domain

import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.data.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddCartProductUseCase @Inject constructor(private val productRepository: ProductRepository) {

    suspend operator fun invoke(productUi: ProductUi) {
        productRepository.addCartProduct(productUi)

    }
}