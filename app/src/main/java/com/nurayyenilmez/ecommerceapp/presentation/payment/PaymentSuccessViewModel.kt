package com.nurayyenilmez.ecommerceapp.presentation.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurayyenilmez.ecommerceapp.domain.DeleteAllCartProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PaymentSuccessViewModel @Inject constructor(
    private val deleteAllCartProductUseCase: DeleteAllCartProductUseCase):ViewModel(){

        fun deleteAllCart(){
            viewModelScope.launch {
                deleteAllCartProductUseCase.invoke()
            }
        }
}