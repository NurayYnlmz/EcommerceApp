package com.nurayyenilmez.ecommerceapp.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.nurayyenilmez.ecommerceapp.R
import com.nurayyenilmez.ecommerceapp.common.addCurrencySign
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.databinding.FragmentProductDetailBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding
    private val viewModel by viewModels<DetailViewModel>()
    private val args: ProductDetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentProductDetailBinding.inflate(
                LayoutInflater.from(requireContext()),
                null, false
            )
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
            }
        }
    }

    private fun productHandleSuccessResponse(product: UiDetailProduct) {
        with(binding) {
            favorite.setImageResource(if (product.isFavorite) R.drawable.delete_favorite else R.drawable.favorite)
            favorite.setOnClickListener { product.onFavorite.invoke() }
            productName.text = product.title
            price.text = product.price.toString().addCurrencySign()
            description.text = product.description
            ratingBar.rating = product.rating?.rate?.toFloat()!!
            ratingCount.text = product.rating.count.toString()


            Picasso.get().load(product.image).into(productImage)

            binding.addToBag.setOnClickListener {
                viewModel.addCartProduct(
                    ProductUi(
                        category = product.category,
                        description = product.description,
                        id = product.id,
                        image = product.image,
                        price = product.price,
                        rating = product.rating,
                        title = product.title
                    )
                )
                Toast.makeText(requireContext(), "Product added to cart.", Toast.LENGTH_SHORT).show()

            }
        }

    }
}







