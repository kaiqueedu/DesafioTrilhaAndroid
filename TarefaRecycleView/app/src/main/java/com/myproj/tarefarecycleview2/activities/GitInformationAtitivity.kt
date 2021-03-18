package com.myproj.tarefarecycleview2.activities

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.myproj.tarefarecycleview2.R
import com.myproj.tarefarecycleview2.models.MyGitData

class GitInformationAtitivity : AppCompatActivity() {

    lateinit var repositoryName: TextView
    lateinit var author: TextView
    lateinit var avatar: ImageView
    lateinit var image: ImageView
    lateinit var description: TextView
    lateinit var favorite: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_git_atitivity)

        bindComponents()
        setIntent()
        setActionListeners()

    }

    private fun setIntent() {
        var intent = intent
        if (intent.hasExtra("git")) {
            var myGitData = intent.getSerializableExtra("git") as MyGitData

            if (myGitData != null) {
                title = myGitData.repositoryName
                setInfos(myGitData)
            }
        }
    }

    private fun bindComponents() {
        repositoryName = findViewById(R.id.git_repository_name)
        author = findViewById(R.id.git_author)
        avatar = findViewById(R.id.git_img_avatar)
        description = findViewById(R.id.git_description)
        image = findViewById(R.id.git_img)
        favorite = findViewById(R.id.git_favorite_icon)
    }

    @SuppressLint("SetTextI18n")
    private fun setInfos(myGitData: MyGitData) {
        repositoryName.text = myGitData.repositoryName
        author.text = myGitData.author
        myGitData.imgAvatar?.let { avatar.setImageResource(it) }
        description.text = "Is simply dummy text of the printing and typesetting industry." +
                            "Contrary to popular belief, Lorem Ipsum is not simply random text." +
                            "It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old."


    }

    private fun setActionListeners() {

        favorite.setOnClickListener{
            Toast.makeText(this, "${repositoryName.text.toString()} Favoritado", Toast.LENGTH_SHORT).show()
        }


    }


}