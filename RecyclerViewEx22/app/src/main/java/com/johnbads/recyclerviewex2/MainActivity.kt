package com.johnbads.recyclerviewex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var itemTitle1 = mutableListOf<String>()
    private var itemDesc1 = mutableListOf<String>()
    private var itemImage = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postToList()
        val rvrecycleView = findViewById<RecyclerView>(R.id.rv_recyclerView)
        rvrecycleView.layoutManager = LinearLayoutManager(this)
        rvrecycleView.adapter = RecyclerAdapter(itemTitle1,itemDesc1,itemImage)
    }
    fun addToList(title: String, Description: String, Image: Int){
        itemTitle1.add(title)
        itemDesc1.add(Description)
        itemImage.add(Image)
    }
    fun postToList(){
        for(i in 1..35){
            addToList("Title: $i", "Description: $i",R.mipmap.ic_launcher_round)
        }
    }
}