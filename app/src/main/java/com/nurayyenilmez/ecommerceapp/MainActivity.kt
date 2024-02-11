package com.nurayyenilmez.ecommerceapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nurayyenilmez.ecommerceapp.databinding.ActivityMainBinding


import com.nurayyenilmez.ecommerceapp.presentation.home.ProductListFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNav, navController)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavigationView.setupWithNavController(navController)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> navController.navigate(R.id.productListFragment)
                R.id.favorites->navController.navigate(R.id.favoritesFragment)


            }
            true
        }

            navController.addOnDestinationChangedListener{_,destination,_ ->
                when(destination.id){
                    R.id.productListFragment,
                        R.id.favoritesFragment->{
                            binding.bottomNav.visibility=View.VISIBLE
                    }
                    else ->{
                            binding.bottomNav.visibility=View.GONE

                }

            }

            }



            }



            }













