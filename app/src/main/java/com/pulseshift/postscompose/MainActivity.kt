package com.pulseshift.postscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pulseshift.postscompose.screens.AppNavigation
import com.pulseshift.postscompose.screens.PostsScreenImpl
import com.pulseshift.postscompose.ui.theme.PostsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PostsComposeTheme {
                Surface(modifier = Modifier.fillMaxSize().safeContentPadding()) {
                AppNavigation()
                }
                }
            }
        }
    }


