package com.nurayyenilmez.ecommerceapp.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurayyenilmez.ecommerceapp.common.ResponseState
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.data.remote.dto.Rating
import com.nurayyenilmez.ecommerceapp.domain.AddCartProductUseCase
import com.nurayyenilmez.ecommerceapp.domain.AddFavoritesUseCase
import com.nurayyenilmez.ecommerceapp.domain.DeleteFavoritesUseCase
import com.nurayyenilmez.ecommerceapp.domain.GetFavoritesUseCase
import com.nurayyenilmez.ecommerceapp.domain.GetSingleProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getSingleProductUseCase: GetSingleProductUseCase,
    private val addFavoritesUseCase: AddFavoritesUseCase,
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val deleteFavoritesUseCase: DeleteFavoritesUseCase,
     private val addCartProductUseCase: AddCartProductUseCase
) : ViewModel() {

    private val _productDetailUiState = MutableLiveData<ProductDetailUiState>()
    val productDetailUiState: LiveData<ProductDetailUiState> get() = _productDetailUiState


    fun singleProduct(id: String) {
        viewModelScope.launch {
            combine(
                getSingleProductUseCase(id), getFavoritesUseCase()
            ) { productResponse, favoriteResponse ->
                when (productResponse) {
                    is ResponseState.Error -> {
                        _productDetailUiState.postValue(productResponse.message?.let {
                            ProductDetailUiState.Error(it)
                        })
                    }

                    ResponseState.Loading -> {
                        _productDetailUiState.postValue(ProductDetailUiState.Loading)
                    }

                    is ResponseState.Success -> {
                        val isFavorite = favoriteResponse.any { it.id == productResponse.data.id }
                        _productDetailUiState.postValue(ProductDetailUiState.Success(UiDetailProduct(
                            category = productResponse.data.category,
                            description = productResponse.data.description,
                            id = productResponse.data.id,
                            image = productResponse.data.image,
                            price = productResponse.data.price,
                            rating = productResponse.data.rating,
                            title = productResponse.data.title,
                            isFavorite = isFavorite,
                            onFavorite = {
                                updateFavoriteProduct(
                                    favorite = isFavorite,
                                    product = productResponse.data,


                                    )

                            }

                        )))
                    }
                }
            }.collect()

        }

    }

    private fun updateFavoriteProduct(favorite: Boolean, product: ProductUi) {
        viewModelScope.launch {
            if (favorite) {
                deleteFavoritesUseCase(product)
            } else {
                addFavoritesUseCase(product)
            }
        }
    }

        fun addCartProduct(product: ProductUi){
            viewModelScope.launch {
                addCartProductUseCase(product)
            }

        }

}

sealed class ProductDetailUiState {
    object Loading : ProductDetailUiState()
    data class Error(val message: String) : ProductDetailUiState()
    data class Success(val data: UiDetailProduct) : ProductDetailUiState()

}

data class UiDetailProduct(
    val category: String?,
    val description: String?,
    val id: String?,
    val image: String?,
    val price: Double?,
    val rating: Rating?,
    val title: String?,
    val isFavorite: Boolean,
    val onFavorite: () -> Unit
)













