package com.myproj.tarefarecycleview2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//TODO: pesquise pelo apply ou o with do koltin, com eles tu pode melhorar muito seu codigo
//TODO: organizar melhor o seu código // ok
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.main_recycleview)
        //TODO: procurar saber o que o setHasFixedSize faz na sua listagem
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // TODO: procurar sobre o padrão de projeto factory para criar blocos de teste
        val myGitData = carregaLista()

        val myGitAdapter = MyGitAdapter(myGitData, ::myCallBack)
        recyclerView.adapter = myGitAdapter

    }

    fun carregaLista(): List<MyGitData>{
        return  listOf(
                MyGitData("Tripa Seca", "Projeto 1", 651, 120, R.drawable.andro_img),
                MyGitData("Quase Nada", "Projeto 2", 334, 1120, R.drawable.ge_img),
                MyGitData("Poucas Tranca", "Projeto 3", 100, 5120, R.drawable.mongo_img),
                MyGitData("Alma Negra", "Projeto 4", 965, 1620, R.drawable.delphi_img),
                MyGitData("Dom Ramon", "Projeto 5", 456, 18420, R.drawable.git_img),
                MyGitData("Chesperito", "Projeto 6", 321, 142, R.drawable.ge_img),
                MyGitData("El Chavo", "Projeto 7", 123, 10000, R.drawable.git_img) )
    }

    fun myCallBack(res: String){
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show()
    }

    //TODO: criar metodos para cada acao feita no onCreate, deixe ele mais limpo
    //TODO: procure usar os outros metodos do ciclo de vida
}