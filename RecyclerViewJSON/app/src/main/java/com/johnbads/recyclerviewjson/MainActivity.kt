package com.johnbads.recyclerviewjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.johnbads.recyclerviewjson.model.Data
import com.johnbads.recyclerviewjson.model.Regres

class MainActivity : AppCompatActivity() {
    private var dataList:MutableList<Data> = mutableListOf()
    private lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myAdapter = MyAdapter(dataList)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        recyclerView.adapter = myAdapter


        AndroidNetworking.initialize(this)
        AndroidNetworking.get("https://reqres.in/api/users?page=2")
            .build()
            .getAsObject(Regres::class.java, object : ParsedRequestListener<Regres>{
                override fun onResponse(response: Regres?) {
                   dataList.addAll(response?.data!!)
                    myAdapter.notifyDataSetChanged()
                }

                override fun onError(anError: ANError?) {

                }

            })
    }
}