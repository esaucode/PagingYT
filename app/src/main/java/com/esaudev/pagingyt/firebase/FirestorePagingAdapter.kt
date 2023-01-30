package com.esaudev.pagingyt.firebase

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.esaudev.pagingyt.databinding.ItemProductBinding

class FirestorePagingAdapter: PagingDataAdapter<Product, FirestorePagingAdapter.ProductViewHolder>(Companion) {

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position) ?: return
        holder.bindProduct(product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding = ItemProductBinding.inflate(
            layoutInflater,
            parent,
            false
        )
        return ProductViewHolder(viewBinding)
    }

    inner class ProductViewHolder(
        private val viewBinding: ItemProductBinding
    ) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bindProduct(product: Product) {
            Log.d("ProductsAdapter", "${product.name} rendered")
            viewBinding.productName.text = product.name
        }
    }

    companion object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

}