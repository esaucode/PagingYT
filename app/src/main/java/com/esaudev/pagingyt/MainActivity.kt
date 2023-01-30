package com.esaudev.pagingyt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.esaudev.pagingyt.databinding.ActivityMainBinding
import com.esaudev.pagingyt.firebase.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private val adapter = ProductsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setRecyclerView()
        getProducts()
    }

    private fun setRecyclerView() {
        binding.productList.adapter = adapter
    }

    private fun getProducts() {
        lifecycleScope.launchWhenCreated {
            viewModel.flow.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}