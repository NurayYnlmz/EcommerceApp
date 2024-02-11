package com.nurayyenilmez.ecommerceapp.di

import com.nurayyenilmez.ecommerceapp.data.source.remote.RemoteDataSource
import com.nurayyenilmez.ecommerceapp.data.source.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
  abstract  fun bindRemoteDataSourceModule(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

}