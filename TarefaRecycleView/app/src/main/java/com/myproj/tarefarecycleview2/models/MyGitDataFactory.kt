package com.myproj.tarefarecycleview2.models

class MyGitDataFactory {

    companion object {
        fun getMyGitData(author: String, repoName: String, totalForks: Int, totalStart: Int, img: Int): MyGitData =
                MyGitData(author, repoName, totalForks, totalStart, img)
    }
}
