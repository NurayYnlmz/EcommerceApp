package com.nurayyenilmez.ecommerceapp.common

import com.nurayyenilmez.ecommerceapp.data.model.ProductListUi
import com.nurayyenilmez.ecommerceapp.data.local.entity.FavoriteProductEntity

import com.nurayyenilmez.ecommerceapp.data.remote.dto.ProductsResponse
import com.nurayyenilmez.ecommerceapp.data.remote.dto.Rating

inline fun <I,O> I.mapTo(crossinline mapper:(I)->O):O{
    return mapper(this)
}
fun ProductsResponse.toProductList():ProductListUi {
    val rating = rating?.let { Rating(it.count, it.rate) }
    return   ProductListUi(
        category = category,
        description = description,
        id = id.toString(),
        image = image,
        price = price,
        rating = rating,
        title = title
    )



}

fun ProductsResponse.toProduct():ProductListUi{
    val rating = rating?.let { Rating(it.count, it.rate) }
    return ProductListUi(
        description = description,
        id = id.toString(),
        image = image,
        price = price,
        rating = rating,
        title = title,
        category = category
    )
}
fun FavoriteProductEntity.toProduct(): ProductListUi {
    val rating = rating?.let { Rating(it.count, it.rate) }
    return ProductListUi(
        id = id.toString(),
        image = image,
        price = price?.toDouble(),
        title = title,
        rating = rating,
        category =category,
        description = description
    )
}

fun ProductListUi.toFavoriteProductEntity(): FavoriteProductEntity {
    return FavoriteProductEntity(
        id = id!!.toInt(),
        image = image,
        price = price.toString(),
        title = title,
        rating = rating,
        category = category,
        description = description
    )
}

fun String.addCurrencySign(): String {
    return "$ $this"
}



