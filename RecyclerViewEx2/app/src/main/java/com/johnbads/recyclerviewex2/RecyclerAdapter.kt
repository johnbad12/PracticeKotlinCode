package com.johnbads.recyclerviewex2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private var titles: List<String>,
                private var desc: List<String>,
                private var images: List<Int>
): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val itemTiles: TextView = itemView.findViewById(R.id.txtTitle)
        val itemDesc: TextView = itemView.findViewById(R.id.txtDesc)
        val itemImages : ImageView = itemView.findViewById(R.id.imageView2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
    val v = LayoutInflater.from( parent.context).inflate(R.layout.item_layout,parent,false)
        return  ViewHolder(v)
    }


    override fun getItemCount(): Int {
       return titles.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.itemTiles.text = titles[position]
      holder.itemDesc.text = desc[position]
        holder.itemImages.setImageResource(images[position])
    }


}