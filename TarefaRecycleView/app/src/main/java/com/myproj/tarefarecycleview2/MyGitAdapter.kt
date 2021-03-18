
package com.myproj.tarefarecycleview2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myproj.tarefarecycleview2.models.MyGitData

class MyGitAdapter(var myGitData: List<MyGitData>, private val myCallBack:(MyGitData) -> Unit) : RecyclerView.Adapter<MyGitAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.git_item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = myGitData[position]
        holder.bind(data)

        holder.itemView.setOnClickListener {
            myCallBack.invoke(data)
        }
    }

    override fun getItemCount(): Int {
        return myGitData.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView = itemView.findViewById(R.id.git_img_avatar)
        var author: TextView = itemView.findViewById(R.id.item_author)
        var repositoryName: TextView = itemView.findViewById(R.id.item_repository_name)
        var totalForks: TextView = itemView.findViewById(R.id.item_fork_total)
        var totalStars: TextView = itemView.findViewById(R.id.item_star_total)

        fun bind(data: MyGitData){
            author.text = data.author
            repositoryName.text = data.repositoryName
            totalForks.text =  "${data.totalForks}"
            totalStars.text = "${data.totalStars}"
            data.imgAvatar?.let { imgAvatar.setImageResource(it) }
        }

    }

}