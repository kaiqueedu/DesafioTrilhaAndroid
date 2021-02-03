package com.myproj.tarefarecycleview2

class MyGitData {
    var author: String? = null
    var repositoryName: String? = null
    var totalForks: Int? = null
    var totalStars: Int? = null
    var imgAvatar: Int? = null

    constructor(author: String?,
                repositoryName: String?,
                totalForks: Int?,
                totalStars: Int?,
                imgAvatar: Int?) {
        this.author = author
        this.repositoryName = repositoryName
        this.imgAvatar = imgAvatar
        this.totalForks = totalForks
        this.totalStars = totalStars
    }

}