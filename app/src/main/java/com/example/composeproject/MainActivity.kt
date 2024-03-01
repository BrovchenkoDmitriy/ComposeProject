package com.example.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composeproject.ui.theme.ComposeProjectTheme
import com.example.composeproject.ui.theme.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ComposeProjectTheme {
//                VkNewsCard()
//            }
            ComposeProjectTheme {
                MainScreen()
            }
        }
    }
}