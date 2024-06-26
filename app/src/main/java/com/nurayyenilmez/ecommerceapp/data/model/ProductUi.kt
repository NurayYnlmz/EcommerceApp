package com.nurayyenilmez.ecommerceapp.data.model

import com.nurayyenilmez.ecommerceapp.data.remote.dto.Rating

data class ProductUi(
    val category: String?,
    val description: String?,
    val id:String?,
    val image: String?,
    val price: Double?,
    val rating: Rating?,
    val title: String?,
    var productQuantity:Int=1


)