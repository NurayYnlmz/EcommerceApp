package com.nurayyenilmez.ecommerceapp.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.nurayyenilmez.ecommerceapp.R
import com.nurayyenilmez.ecommerceapp.common.addCurrencySign
import com.nurayyenilmez.ecommerceapp.databinding.FragmentProductDetailBinding

import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {
    private lateinit var binding:FragmentProductDetailBinding
    private val viewModel by viewModels<DetailViewModel>()
    private val args: ProductDetailFragmentArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=
            FragmentProductDetailBinding.inflate(LayoutInflater.from(requireContext()),
                null, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        obverseUi()
        viewModel.singleProduct(args.id)

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_productDetailFragment_to_productListFragment)
        }

    }
    private fun obverseUi() {
        viewModel.productDetailUiState.observe(viewLifecycleOwner) {
            when (it) {
                is ProductDetailUiState.Error -> {
                }
                ProductDetailUiState.Loading -> {
                }
                is ProductDetailUiState.Success -> {
                    productHandleSuccessResponse(it.data)

                }
            }}
    }

    private fun productHandleSuccessResponse(data: UiDetailProduct) {
        with(binding){
            favorite.setImageResource(if (data.isFavorite) R.drawable.delete_favorite else R.drawable.favorite)
            favorite.setOnClickListener {data.onFavorite.invoke() }
            productName.text=data.title
            price.text=data.price.toString().addCurrencySign()
            description.text=data.description
            ratingBar.rating= data.rating?.rate?.toFloat()!!
            ratingCount.text=data.rating.count.toString()
            Picasso.get().load(data.image).into(productImage)
            }

            }
        }








