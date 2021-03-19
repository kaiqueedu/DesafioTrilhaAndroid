
package com.myproj.tarefarecycleview2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.myproj.tarefarecycleview2.models.MyGitData

class MyGitAdapter(var myGitData: List<MyGitData>, val context: Context, private val myCallBack:(MyGitData) -> Unit) : RecyclerView.Adapter<MyGitAdapter.ViewHolder>() {

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
        var imgAvatar: ImageView? = itemView.findViewById(R.id.git_img_avatar)
        var author: TextView? = itemView.findViewById(R.id.item_author)
        var repositoryName: TextView? = itemView.findViewById(R.id.item_repository_name)
        var totalForks: TextView? = itemView.findViewById(R.id.item_fork_total)
        var totalStars: TextView? = itemView.findViewById(R.id.item_star_total)
        var card: CardView = itemView.findViewById(R.id.item_cardview)

        fun bind(data: MyGitData){
            author?.text = data.author
            repositoryName?.text = data.repositoryName
            totalForks?.text =  "${data.totalForks}"
            totalStars?.text = "${data.totalStars}"
            data.imgAvatar?.let { imgAvatar?.setImageResource(it) }

            setCardColors(data)


        }

        private fun setCardColors(data: MyGitData) {

            val red = context.getResources().getColor(R.color.my_red)
            val orange = context.getResources().getColor(R.color.my_oragen)
            val blue = context.getResources().getColor(R.color.my_blue)

            when (data.totalForks) {
                in 0..10 -> card.setCardBackgroundColor(red)
                in 11..60 -> card.setCardBackgroundColor(orange)
                else -> card.setCardBackgroundColor(blue)
            }
        }

    }

}