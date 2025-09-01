package com.pulseshift.postscompose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pulseshift.postscompose.model.Post
import com.pulseshift.postscompose.viewmodel.PostsViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun PostsScreenImpl(paddingValues: PaddingValues,
    viewModel: PostsViewModel = viewModel()) {

    LaunchedEffect(Unit) {
        viewModel.fetchPosts()
    }

    val posts by viewModel.posts.observeAsState()
    val uiState by viewModel.uiState.observeAsState()


    when{
        uiState?.isLoading == true -> {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        uiState?.success != null -> {
            if (posts != null){
                LazyColumn { items(posts!!){post-> PostCard(post)} }
            }

        }
        uiState?.error != null -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = uiState!!.error.toString())
            }
        }

    }

}

@Composable
fun PostCard(post: Post){
    Card (modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)

    ){
        Column (
            modifier = Modifier.padding(8.dp, 4.dp),


        ){
            Text(text = post.title, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(4.dp))
            Text(text = post.body)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PostsScreenPreview(){
    val post = Post(
        userId = 1,
        id = 1,
        title = "qui est esse",
        body = "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"

    )
    PostCard(post)
}