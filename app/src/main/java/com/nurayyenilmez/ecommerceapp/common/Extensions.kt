package com.nurayyenilmez.ecommerceapp.common

import com.nurayyenilmez.ecommerceapp.data.model.CategoryUi
import com.nurayyenilmez.ecommerceapp.data.model.ProductListUi
import com.nurayyenilmez.ecommerceapp.data.remote.dto.ProductsResponse
import com.nurayyenilmez.ecommerceapp.data.remote.dto.Rating

fun ProductsResponse.toProductList(): ProductListUi {
    val rating = rating?.let { Rating(it.count, it.rate) }
    return ProductListUi(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        rating = rating,
        title = title
    )
}

fun String.toCategory():CategoryUi{
    return CategoryUi(
        name = String()
    )
}

