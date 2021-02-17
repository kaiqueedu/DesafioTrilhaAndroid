package com.myproj.tarefarecycleview2

import androidx.annotation.DrawableRes

data class MyGitData(var author: String? = null,
                     var repositoryName: String? = null,
                     var totalForks: Int? = null,
                     var totalStars: Int? = null,
                     @DrawableRes
                     var imgAvatar: Int? = null) {


}

