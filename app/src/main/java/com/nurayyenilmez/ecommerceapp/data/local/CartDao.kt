package com.nurayyenilmez.ecommerceapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nurayyenilmez.ecommerceapp.data.local.entity.CartProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Query("SELECT * FROM cart_table ORDER BY  id ASC")
    fun getAllCartProduct(): Flow<List<CartProductEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCartProduct(cartProductEntity: CartProductEntity)

    @Delete
    suspend fun deleteCartProduct(cartProductEntity: CartProductEntity)

}
