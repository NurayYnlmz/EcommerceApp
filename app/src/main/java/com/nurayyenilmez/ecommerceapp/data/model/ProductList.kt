package com.nurayyenilmez.ecommerceapp.data.model

import com.nurayyenilmez.ecommerceapp.data.remote.dto.Rating


data class ProductList(
    val category: String?,
    val description: String?,
    val id: Int?,
    val image: String?,
    val price: Double?,
    val rating: Rating?,
    val title: String?
)