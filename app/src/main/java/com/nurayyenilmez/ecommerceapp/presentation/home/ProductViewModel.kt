package com.nurayyenilmez.ecommerceapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.annotations.SerializedName
import com.nurayyenilmez.ecommerceapp.common.ResponseState
import com.nurayyenilmez.ecommerceapp.data.remote.dto.Rating
import com.nurayyenilmez.ecommerceapp.domain.GetAllCategoryUseCase
import com.nurayyenilmez.ecommerceapp.domain.GetAllProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor
    (private val getAllProductUseCase: GetAllProductUseCase,
     private val getAllCategoryUseCase: GetAllCategoryUseCase) :ViewModel(){

      private val _productScreenState=MutableLiveData(ProductUiScreenState.initial())
         val productScreenState: LiveData<ProductUiScreenState> get()=_productScreenState

            fun getAllProduct(){
            viewModelScope.launch {
                getAllProductUseCase().collect{  response->
                    when(response){
                        is ResponseState.Error ->{
                            _productScreenState.
                            postValue(ProductUiScreenState(isError = true, errorMessage =
                            response.message))
                        }

                          ResponseState.Loading -> {
                             _productScreenState.postValue(ProductUiScreenState(isLoading = true))
                          }
                        is ResponseState.Success -> {
                            val products= mutableListOf<UiProduct>()
                            val uiProduct=response.data.map {
                                UiProduct(image = it.image, title = it.title, price = it.price,
                                description = it.description, rating = it.rating)
                            }
                            uiProduct.forEach{
                                products.add(it)
                            }
                            _productScreenState.postValue(ProductUiScreenState(products))
                        }
                    }
                }
            }
        }
    }

data class ProductUiScreenState(
    val product: List<UiProduct> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = " "
) {
    companion object {
        fun initial() =ProductUiScreenState(isLoading = true)
    }
}
data class UiProduct(
    val image: String?,
    val title:String?,
    val price:Double?,
    val description: String?,
    val rating: Rating?,

)


