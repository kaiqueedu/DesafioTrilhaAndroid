package com.myproj.tarefarecycleview2.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myproj.tarefarecycleview2.MyGitAdapter
import com.myproj.tarefarecycleview2.R
import com.myproj.tarefarecycleview2.models.MyGitData
import com.myproj.tarefarecycleview2.models.MyGitDataFactory

//TODO: pesquise pelo apply ou o with do koltin, com eles tu pode melhorar muito seu codigo
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "GitHub Challenge"

        val recyclerView = configuraRecyclerView()
        val myGitData = carregaLista()
        val myGitAdapter = MyGitAdapter(myGitData, this, ::myCallBack)
        recyclerView.adapter = myGitAdapter

    }

    private fun configuraRecyclerView(): RecyclerView {
        val recyclerView = findViewById<RecyclerView>(R.id.main_recycleview)
        recyclerView.setHasFixedSize(true)
        return recyclerView
    }

    private fun carregaLista(): List<MyGitData>{
        return  listOf(
                MyGitDataFactory.getMyGitData("Tripa Seca", "Projeto 1", 10, 120, R.drawable.andro_img),
                MyGitDataFactory.getMyGitData("Quase Nada", "Projeto 2", 50, 1120, R.drawable.ge_img),
                MyGitDataFactory.getMyGitData("Poucas Tranca", "Projeto 3", 2, 5120, R.drawable.git_img),
                MyGitDataFactory.getMyGitData("Alma Negra", "Projeto 4", 150, 1620, R.drawable.delphi_img),
                MyGitDataFactory.getMyGitData("Dom Ramon", "Projeto 5", 60, 18420, R.drawable.git_img),
                MyGitDataFactory.getMyGitData("Chesperito", "Projeto 6", 11, 142, R.drawable.ge_img),
                MyGitDataFactory.getMyGitData("El Chavo", "Projeto 7", 5, 10000, R.drawable.git_img) )
    }

    private fun myCallBack(data: MyGitData){
        var intent = Intent(this, GitInformationAtitivity::class.java)
        intent.putExtra("git", data)
        startActivity(intent)
    }

}