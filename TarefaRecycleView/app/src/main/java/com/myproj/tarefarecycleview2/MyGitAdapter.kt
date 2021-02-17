package com.myproj.tarefarecycleview2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myproj.tarefarecycleview2.models.MyGitData

class MyGitAdapter(var myGitData: List<MyGitData>, val myCallBack:(rest: String) -> Unit) : RecyclerView.Adapter<MyGitAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.git_item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myGitDataList = myGitData[position]
        //TODO: Geralmente essa definicão fica dentro do ViewHolder, geralmente a gente chama uma
        // funcão bind passando o item selecionado na linha acima
        holder.textViewAuthor.text = myGitDataList.author
        holder.textViewRepositoryName.text = myGitDataList.repositoryName
        holder.textViewTotalForks.text =  "${myGitDataList.totalForks}"
        holder.textViewTotalStars.text =  "${myGitDataList.totalStars}"
        holder.imgAvatar.setImageResource(myGitDataList.imgAvatar!!)

        //TODO: usar os strings.xml, pesquisar como concatenar strings de forma dinamica (string builder)
        holder.itemView.setOnClickListener {
            myCallBack.invoke("${myGitDataList.repositoryName}")
        }

    }

    override fun getItemCount(): Int {
        return myGitData.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView = itemView.findViewById(R.id.img_avatar)
        var textViewAuthor: TextView = itemView.findViewById(R.id.author)
        var textViewRepositoryName: TextView = itemView.findViewById(R.id.repo_name)
        var textViewTotalForks: TextView = itemView.findViewById(R.id.fork_total)
        var textViewTotalStars: TextView = itemView.findViewById(R.id.star_total)
    }

}