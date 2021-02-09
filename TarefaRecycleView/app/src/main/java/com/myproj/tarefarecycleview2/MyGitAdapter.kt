package com.myproj.tarefarecycleview2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class MyGitAdapter(var myGitData: Array<MyGitData>, activity: MainActivity) : RecyclerView.Adapter<MyGitAdapter.ViewHolder>() {

    //TODO: não precisa enviar o contexto, usar callbacks
    var context: Context

    init {
        context = activity
    }

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
            Toast.makeText(context, myGitDataList.repositoryName,
                    Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return myGitData.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView
        var textViewAuthor: TextView
        var textViewRepositoryName: TextView
        var textViewTotalForks: TextView
        var textViewTotalStars: TextView

        //TODO: não precisa do init
        init {
            imgAvatar = itemView.findViewById(R.id.img_avatar)
            textViewAuthor = itemView.findViewById(R.id.author)
            textViewRepositoryName = itemView.findViewById(R.id.repo_name)
            textViewTotalForks = itemView.findViewById(R.id.fork_total)
            textViewTotalStars = itemView.findViewById(R.id.star_total)
        }

    }

}