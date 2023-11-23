package com.nurayyenilmez.ecommerceapp.di

import com.nurayyenilmez.ecommerceapp.data.source.RemoteDataSource
import com.nurayyenilmez.ecommerceapp.data.source.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class SourceModule {

    @Binds
    @Singleton
  abstract  fun bindSourceModule(remoteDataSourceImpl: RemoteDataSourceImpl):RemoteDataSource
}