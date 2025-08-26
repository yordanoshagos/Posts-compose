package com.pulseshift.postscompose.repository

import com.pulseshift.postscompose.api.ApiClient
import com.pulseshift.postscompose.api.ApiInterface
import com.pulseshift.postscompose.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class PostsRepository {
    val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun fetchPosts(): Response<List<Post>> {
        return withContext(Dispatchers.IO){
            retrofit.fetchPosts()
        }
    }
}