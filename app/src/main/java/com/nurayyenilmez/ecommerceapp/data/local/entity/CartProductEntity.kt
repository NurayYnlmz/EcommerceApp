package com.nurayyenilmez.ecommerceapp.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nurayyenilmez.ecommerceapp.data.remote.dto.Rating


@Entity(tableName = "cart_table")
 data class CartProductEntity (
    @PrimaryKey(autoGenerate =false)
    var id: Int,
    val image: String?,
    val price: String?,
    @Embedded
    val rating: Rating?,
    val title: String?,
    val category: String?,
    val description: String?,
    var productQuantity:Int=1
    )