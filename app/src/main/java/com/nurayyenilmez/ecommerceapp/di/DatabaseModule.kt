package com.nurayyenilmez.ecommerceapp.di

import android.content.Context
import androidx.room.Room
import com.nurayyenilmez.ecommerceapp.data.local.CartDao
import com.nurayyenilmez.ecommerceapp.data.local.EcommerceDatabase
import com.nurayyenilmez.ecommerceapp.data.local.FavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideFavoritesDb(@ApplicationContext context: Context): EcommerceDatabase =
        Room.databaseBuilder(
            context = context,
            klass = EcommerceDatabase::class.java,
            name = "e_commerce"
        ).build()

    @Provides
    @Singleton
    fun provideFavoriteDao(favoriteDatabase: EcommerceDatabase): FavoriteDao =
        favoriteDatabase.favoriteDao()

    @Provides
    @Singleton
    fun provideCartDao(cartDatabase:EcommerceDatabase): CartDao =
        cartDatabase.cartDao()


}