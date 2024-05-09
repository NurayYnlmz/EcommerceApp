package com.nurayyenilmez.ecommerceapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nurayyenilmez.ecommerceapp.data.local.entity.CartProductEntity
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Query("SELECT * FROM cart_table ORDER BY  id ASC")
    fun getAllCartProduct(): Flow<List<CartProductEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCartProduct(cartProductEntity: CartProductEntity)

    @Delete
    suspend fun deleteCartProduct(cartProductEntity: CartProductEntity)

    @Query("DELETE FROM cart_table")
    suspend fun deleteAllCart()
    @Update
     suspend fun updateCartProduct(cartProductEntity: CartProductEntity)

}
