package com.mayurdw.wheelspinnerapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mayurdw.wheelspinnerapp.databinding.ListAddItemBinding

/**
 * Taken from https://medium.com/swlh/how-data-binding-helps-you-when-working-with-edittext-inside-recyclerview-543a1eb5f2cc
 * */
class AddItemAdapter ( private val itemsList: List<Item>) :
    RecyclerView.Adapter<AddItemAdapter.AddItemViewHolder>() {

    inner class AddItemViewHolder(private val binding : ListAddItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item){
            binding.item = item
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddItemViewHolder =
        AddItemViewHolder(
            ListAddItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: AddItemViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }
    override fun getItemCount(): Int = itemsList.size

    fun updateItems(items: List<Item>?) {
//        itemViewModels = items ?: emptyList()
//        notifyDataSetChanged()
    }
}