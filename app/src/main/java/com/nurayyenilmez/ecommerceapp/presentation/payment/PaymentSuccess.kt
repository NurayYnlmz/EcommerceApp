package com.nurayyenilmez.ecommerceapp.presentation.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nurayyenilmez.ecommerceapp.R
import com.nurayyenilmez.ecommerceapp.databinding.FragmentPaymentSuccessBinding

class PaymentSuccess : Fragment() {

    private lateinit var binding: FragmentPaymentSuccessBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaymentSuccessBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.paymentSuccess.setOnClickListener {
            findNavController().navigate(R.id.action_paymentSuccess_to_productListFragment)
        }
    }
}

