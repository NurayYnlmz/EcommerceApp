package com.nurayyenilmez.ecommerceapp.common

import com.nurayyenilmez.ecommerceapp.data.model.ProductList
import com.nurayyenilmez.ecommerceapp.data.remote.dto.ProductsResponse
import com.nurayyenilmez.ecommerceapp.data.remote.dto.Rating

fun ProductsResponse.toProductList(): ProductList {
    val rating = rating?.let { Rating(it.count, it.rate) }
    return ProductList(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        rating = rating,
        title = title
    )
}

