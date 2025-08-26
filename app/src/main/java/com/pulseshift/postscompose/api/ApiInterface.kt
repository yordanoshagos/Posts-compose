package com.pulseshift.postscompose.api

import com.pulseshift.postscompose.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {
    @GET("/posts")
    suspend fun fetchPosts(): Response<List<Post>>

    @GET("/posts/{postId}")
    suspend fun fetchPostId(@Path("postId") postId: Int): Response<Post>
}