package com.nurayyenilmez.ecommerceapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nurayyenilmez.ecommerceapp.data.local.entity.CartProductEntity
import com.nurayyenilmez.ecommerceapp.data.local.entity.FavoriteProductEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface  FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavoriteProduct(favoriteProductEntity: FavoriteProductEntity)

    @Delete
    suspend fun deleteFavoriteProduct(favoriteProductEntity: FavoriteProductEntity)

    @Query("SELECT * FROM favorite_table ORDER BY  id ASC")
    fun getAllFavoriteProduct():Flow<List<FavoriteProductEntity>>

//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun addCartProduct(cartProductEntity: CartProductEntity)

}