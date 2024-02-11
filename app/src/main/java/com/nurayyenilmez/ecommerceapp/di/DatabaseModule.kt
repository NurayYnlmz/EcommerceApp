package com.nurayyenilmez.ecommerceapp.di

import android.content.Context
import androidx.room.Room
import com.nurayyenilmez.ecommerceapp.data.local.FavoriteDao
import com.nurayyenilmez.ecommerceapp.data.local.FavoriteDatabase
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
       fun provideFavoritesDb(@ApplicationContext context: Context): FavoriteDatabase
       =Room.databaseBuilder(context = context,
       klass = FavoriteDatabase::class.java,
       name = "favorite_database").build()

       @Provides
       @Singleton
       fun provideFavoriteDao(favoriteDatabase: FavoriteDatabase): FavoriteDao =
        favoriteDatabase.favoriteDao()

       }