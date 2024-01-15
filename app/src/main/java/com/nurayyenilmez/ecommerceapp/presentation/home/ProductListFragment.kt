package com.nurayyenilmez.ecommerceapp.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nurayyenilmez.ecommerceapp.R
import com.nurayyenilmez.ecommerceapp.databinding.FragmentProductListBinding
import com.nurayyenilmez.ecommerceapp.presentation.home.adapter.AllProductAdapter
import com.nurayyenilmez.ecommerceapp.presentation.home.adapter.CategoryAdapter
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.Text
@AndroidEntryPoint
class ProductListFragment : Fragment() {
   private lateinit var binding: FragmentProductListBinding
   private val viewModel by viewModels<ProductViewModel>()
    private  var adapter= AllProductAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=
            FragmentProductListBinding.inflate(LayoutInflater.from(requireContext()),
                null, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        obverseUi()
        viewModel.getAllProduct()

    }

    private fun obverseUi() {
        viewModel.productScreenState.observe(viewLifecycleOwner) {
            when {
                it.isError -> {
                    productHandleError(it.errorMessage)
                }

                it.isLoading -> {
                    productHandleLoading()
                }

                else -> {
                    productHandleSuccess(it.product)
                }

            }
        }
    }

    private fun productHandleSuccess(product: List<UiProduct>) {
        adapter.updateProduct(product)
        binding.productRecyclerView.adapter=adapter
        binding.productRecyclerView.layoutManager=
          GridLayoutManager(requireContext(),2)
    }

    private fun productHandleLoading() {

    }

    private fun productHandleError(errorMessage: String?) {


    }



}




