package com.nurayyenilmez.ecommerceapp.presentation.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.domain.DeleteCartProductUseCase
import com.nurayyenilmez.ecommerceapp.domain.GetAllCartProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.temporal.TemporalAmount
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(
    private val getAllCartProductUseCase: GetAllCartProductUseCase,
    private val deleteCartProductUseCase: DeleteCartProductUseCase,
) : ViewModel() {

    private val _cartProduct = MutableLiveData<List<ProductUi>>()
    val cartProduct: LiveData<List<ProductUi>> get() = _cartProduct

    fun getAllCartProduct() {
        viewModelScope.launch {
            getAllCartProductUseCase.invoke().collect {
                _cartProduct.postValue(it)
            }
        }
    }
    fun deleteCartProduct(productUi: ProductUi) {
        viewModelScope.launch {
            deleteCartProductUseCase.invoke(productUi)
        }
    }


}

