package com.nurayyenilmez.ecommerceapp.domain

import com.nurayyenilmez.ecommerceapp.data.model.ProductListUi
import com.nurayyenilmez.ecommerceapp.data.repository.ProductRepository
import javax.inject.Inject

class DeleteFavoritesUseCase @Inject constructor(private val productRepository: ProductRepository) {

        suspend operator fun invoke(productListUi: ProductListUi){
        productRepository.deleteFavorites(productListUi)
    }
}