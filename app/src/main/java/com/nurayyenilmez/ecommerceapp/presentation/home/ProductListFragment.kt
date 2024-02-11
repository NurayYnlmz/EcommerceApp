package com.nurayyenilmez.ecommerceapp.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.nurayyenilmez.ecommerceapp.databinding.FragmentProductListBinding
import com.nurayyenilmez.ecommerceapp.presentation.home.adapter.AllProductAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {
    private lateinit var binding: FragmentProductListBinding
    private val viewModel by viewModels<ProductViewModel>()
    private var adapter = AllProductAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentProductListBinding.inflate(
                LayoutInflater.from(requireContext()),
                null, false
            )
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        obverseUi()
        viewModel.getAllProduct()
        adapter.setOnProductItemClickListener { id ->
            val action =
                ProductListFragmentDirections.actionProductListFragmentToProductDetailFragment(id)
            findNavController().navigate(action)
        }

    }

    private fun obverseUi() {
        viewModel.productUiState.observe(viewLifecycleOwner) {
            when (it) {
                is ProductUiScreenState.Error -> {

                }

                ProductUiScreenState.Loading -> {

                }

                is ProductUiScreenState.Success -> {
                    productHandleSuccess(it.data)
                }
            }
        }
    }

    private fun productHandleSuccess(product: List<UiProduct>) {
        adapter.updateProduct(product)
        binding.productRecyclerView.adapter = adapter
        binding.productRecyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2)
    }
}




