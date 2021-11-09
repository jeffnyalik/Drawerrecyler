package com.example.mobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder> (){
    private val title = arrayOf("ChapterOne", "Chapter2", "Chapter3", "Chapter4", "Chapter5")
    private val details = arrayOf(
        "Item One details",
        "Item two details",
        "Item three details",
        "Item four details",
        "Item five details"
    )

    private val images = arrayOf(
        R.drawable.img5,
        R.drawable.img5,
        R.drawable.img5,
        R.drawable.img5,
        R.drawable.img5,
    )

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDesc: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDesc = itemView.findViewById(R.id.item_desc)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDesc.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }
}