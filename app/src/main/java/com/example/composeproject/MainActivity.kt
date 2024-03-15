package com.example.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.composeproject.ui.theme.ComposeProjectTheme
import com.example.composeproject.ui.theme.MainScreenNew
import com.example.composeproject.ui.theme.MainViewModel
import com.example.composeproject.ui.theme.TestLazyColumn
import com.example.composeproject.ui.theme.VkNewsMainScreenViewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                MainScreenNew(viewModel = viewModel)
            }
        }
    }
}