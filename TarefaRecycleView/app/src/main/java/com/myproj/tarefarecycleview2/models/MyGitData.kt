package com.myproj.tarefarecycleview2.models

import androidx.annotation.DrawableRes
import java.io.Serializable

data class MyGitData(var author: String? = null,
                     var repositoryName: String? = null,
                     var totalForks: Int? = null,
                     var totalStars: Int? = null,
                     @DrawableRes
                     var imgAvatar: Int? = null): Serializable {

}

