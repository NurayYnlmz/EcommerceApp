package com.nurayyenilmez.ecommerceapp.domain

import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.data.repository.ProductRepository
import javax.inject.Inject

class DeleteFavoritesUseCase @Inject constructor(private val productRepository: ProductRepository) {

        suspend operator fun invoke(productListUi: ProductUi){
        productRepository.deleteFavorites(productListUi)
    }
}