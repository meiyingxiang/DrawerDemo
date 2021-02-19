package com.example.drawerdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_image_layout.view.*

class MyListAdapter(private val isPager: Boolean) : ListAdapter<Int, RecyclerView.ViewHolder>(DIAMONDBACK) {

    object DIAMONDBACK : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.item_image_layout, parent, false)
        if (isPager) {
            inflate.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
            inflate.itemImageView.layoutParams.height = 0
            inflate.itemImageView.layoutParams.width = 0
        }
        return object : RecyclerView.ViewHolder(inflate) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.itemImageView.setImageResource(getItem(position))
    }
}