package com.myproj.tarefarecycleview2

import androidx.annotation.DrawableRes

//TODO: usar data class
class MyGitData {
    var author: String? = null
    var repositoryName: String? = null
    var totalForks: Int? = null
    var totalStars: Int? = null
    @DrawableRes // TODO: essa assinatua garante que tu so vai enviar um Resource Drawable
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