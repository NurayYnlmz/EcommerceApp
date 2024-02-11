package com.nurayyenilmez.ecommerceapp.di

import com.nurayyenilmez.ecommerceapp.data.source.local.LocalDataSource
import com.nurayyenilmez.ecommerceapp.data.source.local.LocalDataSourceImpl

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn( SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    @Singleton
    abstract  fun bindLocaleDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

}