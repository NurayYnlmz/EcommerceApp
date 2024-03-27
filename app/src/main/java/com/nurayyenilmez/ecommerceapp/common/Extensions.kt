package com.nurayyenilmez.ecommerceapp.common

import com.nurayyenilmez.ecommerceapp.data.local.entity.CartProductEntity
import com.nurayyenilmez.ecommerceapp.data.local.entity.FavoriteProductEntity
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.data.remote.dto.ProductsResponse
import com.nurayyenilmez.ecommerceapp.data.remote.dto.Rating

inline fun <I, O> I.mapTo(crossinline mapper: (I) -> O): O {
    return mapper(this)
}

fun ProductsResponse.toProductList(): ProductUi {
    val rating = rating?.let { Rating(it.count, it.rate) }
    return ProductUi(
        category = category,
        description = description,
        id = id.toString(),
        image = image,
        price = price,
        rating = rating,
        title = title
    )


}

fun ProductsResponse.toFavoriteProduct(): ProductUi {
    val rating = rating?.let { Rating(it.count, it.rate) }
    return ProductUi(
        description = description,
        id = id.toString(),
        image = image,
        price = price,
        rating = rating,
        title = title,
        category = category
    )
}

fun FavoriteProductEntity.toFavoriteProduct(): ProductUi {
    val rating = rating?.let { Rating(it.count, it.rate) }
    return ProductUi(
        id = id.toString(),
        image = image,
        price = price?.toDouble(),
        title = title,
        rating = rating,
        category = category,
        description = description
    )
}

fun ProductUi.toFavoriteProductEntity(): FavoriteProductEntity {
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

fun CartProductEntity.toCartProduct(): ProductUi {
    val rating = rating?.let { Rating(it.count, it.rate) }
    return ProductUi(
        id = id.toString(),
        image = image,
        price = price?.toDouble(),
        title = title,
        rating = rating,
        category =category,
        description = description
    )
}

fun ProductUi.toCartProductEntity():CartProductEntity{
    return CartProductEntity(
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



