package com.johnbads.recyclerviewjson

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.johnbads.recyclerviewjson.model.Data
import com.squareup.picasso.Picasso

class MyAdapter(private val dataList: MutableList<Data>): RecyclerView.Adapter<MyHolder>() {

    private lateinit var context:Context
//    private val fullname = findViewById<TextView>(R.id.user_full_name)
//    private val imgSrc = findViewById<ImageView>(R.id.user_avatar)

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyHolder {
     context = parent.context
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent,false))

    }
    override fun getItemCount(): Int = dataList.size


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
      val data = dataList[position]

        val userFullNameTextView = holder.itemView.findViewById<TextView>(R.id.user_full_name)
        val userAvatar    = holder.itemView.findViewById<ImageView>(R.id.user_avatar)

        val fullName = "${data.firstName} ${data.lastName}"
        userFullNameTextView.text = fullName

        Picasso.get()
            .load(data.avatar)
            .into(userAvatar)
        holder.itemView.setOnClickListener {
            Toast.makeText(context, fullName, Toast.LENGTH_SHORT).show()

        }
    }


}