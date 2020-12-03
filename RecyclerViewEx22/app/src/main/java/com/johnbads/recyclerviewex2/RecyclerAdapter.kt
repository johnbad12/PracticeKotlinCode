package com.johnbads.recyclerviewex2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class RecyclerAdapter(private var title: List<String>,
            private var desc: List<String>,
            private var image: List<Int>
): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>()
{
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val itemTitle: TextView = itemView.findViewById(R.id.txtTitle)
        val itemDesc: TextView = itemView.findViewById(R.id.txtDesc)
        val itemImage: ImageView = itemView.findViewById(R.id._imageView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
    val v =  LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return title.size

    }
    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
       holder.itemTitle.text =  title[position]
        holder.itemDesc.text = desc[position]
        holder.itemImage.setImageResource(image[position])
    }

}