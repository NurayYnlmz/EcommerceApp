package com.nurayyenilmez.ecommerceapp.presentation.cart

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nurayyenilmez.ecommerceapp.common.addCurrencySign
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.databinding.FragmentCartBinding
import com.nurayyenilmez.ecommerceapp.presentation.cart.adapter.CartProductAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private val viewModel by viewModels<CartViewModel>()
    private val cartAdapter = CartProductAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()

        binding.cartRecyclerView.adapter = cartAdapter
        viewModel.getAllCartProduct()
        cartAdapter.setOnCartDeleteClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Delete!!")
                .setMessage("Are you sure want to remove it ?")
                .setPositiveButton("Yes") { _, _ ->
                    viewModel.deleteCartProduct(
                        ProductUi(
                            category = it,
                            description = it,
                            id = it,
                            image = it,
                            price = it.toDouble(),
                            rating = null,
                            title = it,
                            productQuantity = it.toInt()
                        )
                    )
                }
                .setNegativeButton("No", null)
                .show()


        }

    }

    private fun observeData() {
        viewModel.cartProduct.observe(viewLifecycleOwner) {
            binding.buy.setOnClickListener { clicklistener ->
                if (it.isNotEmpty()) {
                    val action = CartFragmentDirections.actionCartFragmentToPayment()
                    findNavController().navigate(action)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Sepetinizde ürün bulunmamaktadır!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            cartAdapter.updateCartProduct(it)
            updateTotalPrice(it)

            cartAdapter.setOnIncreaseClickListener {
                viewModel.increase(it)
            }

            cartAdapter.setOnDecreaseClickListener {
                viewModel.decrease(it)
            }



            if (it.isEmpty()) {
                binding.emptyBasket.visibility = View.VISIBLE
                binding.basket.visibility = View.VISIBLE
                binding.buy.visibility = View.GONE
                binding.totalAmount.visibility = View.GONE
                binding.total.visibility = View.GONE
            } else {
                binding.emptyBasket.visibility = View.GONE
                binding.basket.visibility = View.GONE
                binding.buy.visibility = View.VISIBLE
                binding.totalAmount.visibility = View.VISIBLE
                binding.total.visibility = View.VISIBLE


            }
        }
    }

    private fun totalPrice(cartProducts: List<ProductUi>): Double {
        var totalPrice = 0.0
        for (product in cartProducts) {
            product.price?.let {
                totalPrice += product.productQuantity.toFloat() * it
            }
        }
        return totalPrice
    }

    private fun updateTotalPrice(cartProducts: List<ProductUi>) {
        val totalPrice = totalPrice(cartProducts)
        binding.totalAmount.text = totalPrice.toString().addCurrencySign()

    }

}


