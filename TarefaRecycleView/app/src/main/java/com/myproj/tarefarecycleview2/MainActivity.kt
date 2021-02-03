package com.myproj.tarefarecycleview2

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.main_recycleview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val myGitData = arrayOf(
                MyGitData("Tripa Seca", "Projeto 1", 651, 120, R.drawable.andro_img),
                MyGitData("Quase Nada", "Projeto 2", 334, 1120, R.drawable.ge_img),
                MyGitData("Poucas Tranca", "Projeto 3", 100, 5120, R.drawable.mongo_img),
                MyGitData("Alma Negra", "Projeto 4", 965, 1620, R.drawable.delphi_img),
                MyGitData("Dom Ramon", "Projeto 5", 456, 18420, R.drawable.git_img),
                MyGitData("Chesperito", "Projeto 6", 321, 142, R.drawable.ge_img),
                MyGitData("El Chavo", "Projeto 7", 123, 10000, R.drawable.git_img)
        )
        val myGitAdapter = MyGitAdapter(myGitData, this@MainActivity)
        recyclerView.adapter = myGitAdapter

    }

}