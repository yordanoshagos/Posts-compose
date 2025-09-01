package com.pulseshift.postscompose.model

import com.google.gson.annotations.SerializedName

data class Comment (
    val id: Int,
    val postId: Int,
//    @SerializedName("post_id") val postId: Int,
    val name: String,
    val email: String,
    val body: String
)
