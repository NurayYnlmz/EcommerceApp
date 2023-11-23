package com.nurayyenilmez.ecommerceapp.di

import com.nurayyenilmez.ecommerceapp.data.repository.ProductRepository
import com.nurayyenilmez.ecommerceapp.data.repository.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{

    @Singleton
    @Binds
    abstract fun bindProductRepository(productRepositoryImpl: ProductRepositoryImpl):ProductRepository



}