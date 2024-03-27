package com.nurayyenilmez.ecommerceapp.presentation.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nurayyenilmez.ecommerceapp.R
import com.nurayyenilmez.ecommerceapp.databinding.FragmentPaymentSuccessBinding
import com.nurayyenilmez.ecommerceapp.presentation.favorites.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentSuccess : Fragment() {

    private lateinit var binding: FragmentPaymentSuccessBinding
    private val viewModel by viewModels<PaymentSuccessViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaymentSuccessBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         viewModel.deleteAllCart()
        binding.paymentSuccess.setOnClickListener {
           val action= PaymentSuccessDirections.actionPaymentSuccessToProductListFragment()
            findNavController().navigate(action)

        }
    }
}

