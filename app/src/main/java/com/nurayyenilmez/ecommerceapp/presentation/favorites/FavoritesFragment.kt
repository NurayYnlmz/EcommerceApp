package com.nurayyenilmez.ecommerceapp.presentation.favorites

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nurayyenilmez.ecommerceapp.data.model.ProductUi
import com.nurayyenilmez.ecommerceapp.databinding.FragmentFavoritesBinding
import com.nurayyenilmez.ecommerceapp.presentation.cart.adapter.CartProductAdapter
import com.nurayyenilmez.ecommerceapp.presentation.favorites.adapter.FavoriteProductAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding
    private val viewModel by viewModels<FavoriteViewModel>()
    private val favoriteAdapter = FavoriteProductAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllFavoriteProduct()
        observeData()
        initAdapter()


    }

    private fun getAllFavoriteProduct() {
        viewModel.getAllFavorite()
    }

    private fun observeData() {
        viewModel.favoriteProduct.observe(viewLifecycleOwner) {
            favoriteAdapter.updateFavoriteProduct(it)
            if (it.isEmpty()){
                binding.favorite.visibility=View.VISIBLE
                binding.emptyFavorite.visibility=View.VISIBLE
            }else{
                binding.favorite.visibility=View.GONE
                binding.emptyFavorite.visibility=View.GONE
            }
        }
    }
    private fun initAdapter() {
        binding.favoriteRecyclerView.adapter = favoriteAdapter
        favoriteAdapter.setOnFavoriteDeleteClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Delete!!")
                .setMessage("Are you sure want to remove it ?")
                .setPositiveButton("Yes") { _, _ ->
                    viewModel.deleteFavorite(
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

}

