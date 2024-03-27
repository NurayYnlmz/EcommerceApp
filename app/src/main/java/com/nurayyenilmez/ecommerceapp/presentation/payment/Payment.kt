package com.nurayyenilmez.ecommerceapp.presentation.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.nurayyenilmez.ecommerceapp.R
import com.nurayyenilmez.ecommerceapp.databinding.FragmentPaymentBinding

class Payment : Fragment() {

    private lateinit var binding: FragmentPaymentBinding

    private val monthList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    private val yearList = listOf(2024, 2025, 2026, 2027, 2028, 2029, 2030, 2031, 2032)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        monthAutoComplete()
        yearAutoComplete()

        binding.cardBack.setOnClickListener {
            findNavController().navigate(R.id.action_payment_to_cartFragment)

        }
        binding.pay.setOnClickListener {
            if (checkCardInfo(
                    binding.textInputEditTextCardName,
                    binding.textInputEditTextCardNumber,
                    binding.monthAutoComplete,
                    binding.yearAutoComplete,
                    binding.paymentCvvEditText,
                    binding.textInputEditTextAddress
                )
            ) {
                val action = PaymentDirections.actionPaymentToPaymentSuccess()
                findNavController().navigate(action)
            }
        }
    }

    private fun yearAutoComplete() {
        val yearAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown_menu, yearList)
        binding.yearAutoComplete.setAdapter(yearAdapter)
        binding.yearAutoComplete.setOnItemClickListener { _, _, position, id ->
            yearList[position]
        }
    }

    private fun monthAutoComplete() {
        val monthAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown_menu, monthList)
        binding.monthAutoComplete.setAdapter(monthAdapter)
        binding.monthAutoComplete.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, id ->
                monthList[position]
            }
    }


    fun TextInputEditText.validateCardInfo(
        errorMessage: String,
        textField: TextInputEditText
    ): Boolean {
        return if (textField.text.toString().isNullOrEmpty()) {
            textField.error = errorMessage
            false

        } else {
            textField.error = null
            true
        }

    }

    
    fun AutoCompleteTextView.validateCartMonthAndYear(
        errorMessage: String,
        textField: AutoCompleteTextView
    ): Boolean {
        return if (textField.text.toString().isNullOrEmpty()) {
            textField.error = errorMessage
            false
        } else {
            textField.error = null
            true
        }
    }

    private fun checkCardInfo(
        cardName: TextInputEditText,
        cardNumber: TextInputEditText,
        cardMount: AutoCompleteTextView,
        cardYear: AutoCompleteTextView,
        cardCvv: TextInputEditText,
        cardAddress: TextInputEditText
    ): Boolean {

        val cardNameInfo = cardName.validateCardInfo(
            getString(R.string.card_name),
            textField = binding.textInputEditTextCardName
        )

        val cardNumberInfo = cardNumber.validateCardInfo(
            getString(R.string.card_number),
            textField = binding.textInputEditTextCardNumber
        )
        val cardMounthInfo = cardMount.validateCartMonthAndYear(
            getString(R.string.error_month),
            textField = binding.monthAutoComplete
        )
        val cardYearInfo = cardYear.validateCartMonthAndYear(
            getString(R.string.error_year),
            textField = binding.yearAutoComplete
        )
        val cardCvvInfo = cardCvv.validateCardInfo(
            getString(R.string.error_cvv),
            textField = binding.paymentCvvEditText
        )
        val cardAddressInfo = cardAddress.validateCardInfo(
            getString(R.string.error_address),
            textField = binding.textInputEditTextAddress
        )
        return cardNameInfo && cardNumberInfo && cardMounthInfo && cardYearInfo && cardCvvInfo && cardAddressInfo

    }
}






