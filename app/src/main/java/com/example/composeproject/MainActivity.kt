package com.example.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.composeproject.ui.theme.ComposeProjectTheme
import com.example.composeproject.ui.theme.MainScreenNew

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<FeedPostsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                MainScreenNew(viewModel = viewModel)
            }
        }
    }
}