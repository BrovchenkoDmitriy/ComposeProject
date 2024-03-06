package com.example.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.composeproject.ui.theme.ComposeProjectTheme
import com.example.composeproject.ui.theme.InstagramProfileCard
import com.example.composeproject.ui.theme.MainScreen
import com.example.composeproject.ui.theme.VkNewsMainScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[VkNewsMainScreenViewModel::class.java]
        setContent {
//            ComposeProjectTheme {
//                VkNewsCard()
//            }
            ComposeProjectTheme {
                InstagramProfileCard(viewModel = viewModel)
//                MainScreen()
            }
        }
    }
}