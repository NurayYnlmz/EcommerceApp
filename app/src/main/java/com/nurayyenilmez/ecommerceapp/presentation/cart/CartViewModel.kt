package com.nurayyenilmez.ecommerceapp.presentation.cart


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.domain.DeleteCartProductUseCase
import com.nurayyenilmez.ecommerceapp.domain.GetAllCartProductUseCase
import com.nurayyenilmez.ecommerceapp.domain.UpdateCartProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(
    private val getAllCartProductUseCase: GetAllCartProductUseCase,
    private val deleteCartProductUseCase: DeleteCartProductUseCase,
    private val updateCartProductUseCase: UpdateCartProductUseCase
) : ViewModel() {
    private val _cartProduct = MutableLiveData<List<ProductUi>>()
    val cartProduct: LiveData<List<ProductUi>> get() = _cartProduct

    private val _totalAmount = MutableLiveData(0.0)
    val totalAmount: LiveData<Double> = _totalAmount

    fun increase(product: ProductUi) {
        _totalAmount.value = product.price?.let { _totalAmount.value?.plus(it) }
        updateBasket(product)
    }

    fun decrease(product: ProductUi) {
        _totalAmount.value = product.price?.let { _totalAmount.value?.minus(it) }
         updateBasket(product)
    }

    private fun updateBasket(product: ProductUi) {
        viewModelScope.launch(Dispatchers.IO) {
            updateCartProductUseCase(product)
        }
    }

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








