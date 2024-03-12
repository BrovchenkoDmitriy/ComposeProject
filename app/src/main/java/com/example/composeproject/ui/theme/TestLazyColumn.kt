package com.example.composeproject.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.composeproject.R

@Composable
fun TestLazyColumn(viewModel: VkNewsMainScreenViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LazyColumn {
            item {
                Text(text = "Zagolovok")
            }
            items(count = 10) {
                InstagramProfileCard(viewModel = viewModel)
            }
            item {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
            }
            items(count = 200) {
                InstagramProfileCard(viewModel = viewModel)
            }
        }
    }
}