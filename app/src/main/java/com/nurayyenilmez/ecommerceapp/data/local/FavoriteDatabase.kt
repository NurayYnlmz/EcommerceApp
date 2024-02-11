package com.nurayyenilmez.ecommerceapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nurayyenilmez.ecommerceapp.data.local.entity.FavoriteProductEntity


@Database(entities = [FavoriteProductEntity::class], version = 1, exportSchema = false)
abstract class FavoriteDatabase :RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
}