package com.nurayyenilmez.ecommerceapp.presentation.favorites


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.domain.AddCartProductUseCase
import com.nurayyenilmez.ecommerceapp.domain.DeleteFavoritesUseCase

import com.nurayyenilmez.ecommerceapp.domain.GetFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val deleteFavoritesUseCase: DeleteFavoritesUseCase,


) : ViewModel() {

    private val _favoriteProduct = MutableLiveData<List<ProductUi>>()
    val favoriteProduct: LiveData<List<ProductUi>> get() = _favoriteProduct


    fun getAllFavorite() {
        viewModelScope.launch {
            getFavoritesUseCase.invoke().collect {
                _favoriteProduct.postValue(it)

            }
        }
    }
    fun deleteFavorite(productListUi: ProductUi) {
        viewModelScope.launch {
            deleteFavoritesUseCase.invoke(productListUi)
        }
    }

}


