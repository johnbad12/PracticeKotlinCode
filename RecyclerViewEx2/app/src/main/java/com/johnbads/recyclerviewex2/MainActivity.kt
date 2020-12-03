package com.johnbads.recyclerviewex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var titles = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var images = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postToList()

        val rvrecyclerView = findViewById<RecyclerView>(R.id.rv_recyclerView)
        rvrecyclerView.layoutManager = LinearLayoutManager(this)
        rvrecyclerView.adapter = RecyclerAdapter(titles,descList,images )


    }
    fun addToList(title:String, description: String, image: Int){
        titles.add(title)
        descList.add(description)
        images.add(image)

    }
    fun postToList(){
        for( i in 1..25){
            addToList("Title: $i", "Description: $i", R.mipmap.ic_launcher_round)
        }
    }

}