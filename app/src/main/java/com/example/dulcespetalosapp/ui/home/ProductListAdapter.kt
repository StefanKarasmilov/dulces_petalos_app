package com.example.dulcespetalosapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dulcespetalosapp.databinding.ProductListItemBinding
import com.example.dulcespetalosapp.models.ProductModel

class ProductListAdapter(
    private val data: List<ProductModel>,
    private val onItemClick: (flowerId: String) -> Unit
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding = ProductListItemBinding.inflate(
            layoutInflater,
            viewGroup,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(data[position], onItemClick)
    }

    override fun getItemCount() = data.size


    class ViewHolder(private val binding: ProductListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductModel, onItemClick: (flowerId: String) -> Unit) {
            binding.model = item

            itemView.setOnClickListener { onItemClick(item.id) }
        }
    }

}