package com.utad.navegacion.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.utad.navegacion.databinding.ItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class RecyclerViewAdapter(

    private val itemList: List<New>,

    val actionClick: (titleId: String) -> Unit


): RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater,parent,false)
        return ItemViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val item = itemList[position]

        holder.binding.tvItemName.text = item.title
        Glide.with(holder.binding.root)
            .load(item.image)
            .into(holder.binding.ivItemImage)
             holder.binding.root.setOnClickListener { actionClick(item.title) }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    inner class ItemViewHolder (val binding: ItemBinding): ViewHolder(binding.root)
}