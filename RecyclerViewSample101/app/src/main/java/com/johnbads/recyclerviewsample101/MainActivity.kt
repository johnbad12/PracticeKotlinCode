package com.johnbads.recyclerviewsample101

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageList = listOf<Image>(
            Image(R.drawable.imgcctv,
            "CCTV Information",
            "This Information is for sending the data to the supplier for resetting the password to default"

            ),
            Image(R.drawable.imggas,
            "GAS",
                "assumes the shape and volume of its container\n" +
                        "particles can move past one another"
                ),
            Image(R.drawable.imgliquid,
             "LIQUID",
                "assumes the shape of the part of the container which it occupies\n" +
                        "particles can move/slide past one another"
            ),
            Image(R.drawable.imgmio,
            "MIO PARTS",
            "The Battery parts for mio"
            ),
            Image(R.drawable.imgsolid,
            "Solid",
            "retains a fixed volume and shape\n" +
                    "rigid - particles locked into place"
            )
        )
        // to define recyclerView 
        val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this,imageList){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

    }

}