package com.pulseshift.postscompose.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object Posts : Screen("posts")
    object ViewPost : Screen("viewPost")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Posts.route) {
        composable(Screen.Posts.route) {
            PostsScreenImpl(
                onClickPost = {postId -> navController.navigate("${Screen.ViewPost.route}/$postId") }
            )
        }
        composable("${Screen.ViewPost.route}/{postId}") { navBackStackEntry ->
            val postId = navBackStackEntry.arguments?.getString("postId")
            if (postId != null) {
                VIewPostScreen(postId.toInt())
            }
        }
    }
}
