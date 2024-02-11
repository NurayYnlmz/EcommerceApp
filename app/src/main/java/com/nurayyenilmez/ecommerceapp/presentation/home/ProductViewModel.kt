package com.nurayyenilmez.ecommerceapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.nurayyenilmez.ecommerceapp.common.ResponseState
import com.nurayyenilmez.ecommerceapp.domain.GetAllProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor
    (private val getAllProductUseCase: GetAllProductUseCase,
    ) :ViewModel(){

    private val _productUiState = MutableLiveData<ProductUiScreenState>()
    val productUiState: LiveData<ProductUiScreenState> get() = _productUiState

    fun getAllProduct(){
            viewModelScope.launch {
                getAllProductUseCase().collect{  response->
                    when(response){
                        is ResponseState.Error ->{
                            _productUiState.
                            postValue(response.message?.let { ProductUiScreenState.Error(it) })
                        }

                          ResponseState.Loading -> {
                             _productUiState.postValue(ProductUiScreenState.Loading)
                          }
                        is ResponseState.Success -> {
                            val products= mutableListOf<UiProduct>()
                            val uiProduct=response.data.map {
                                UiProduct(image = it.image, title = it.title, price = it.price, id = it.id)
                            }
                            uiProduct.forEach{
                                products.add(it)
                            }
                            _productUiState.postValue(ProductUiScreenState.Success(uiProduct))
                        }
                    }
                }
            }
        }
    }

sealed class ProductUiScreenState {
    object Loading : ProductUiScreenState()
    data class Error(val message: String) :ProductUiScreenState()
    data class Success(val data: List<UiProduct>) : ProductUiScreenState()

}
data class UiProduct(
    val id: String?,
    val image: String?,
    val title:String?,
    val price:Double?,

    )


