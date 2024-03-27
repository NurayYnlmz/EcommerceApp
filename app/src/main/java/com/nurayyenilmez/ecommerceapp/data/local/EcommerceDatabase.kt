package com.nurayyenilmez.ecommerceapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nurayyenilmez.ecommerceapp.data.local.entity.CartProductEntity
import com.nurayyenilmez.ecommerceapp.data.local.entity.FavoriteProductEntity


@Database(entities = [FavoriteProductEntity::class,CartProductEntity::class], version = 1, exportSchema = false)
abstract class EcommerceDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
    abstract fun cartDao():CartDao
}