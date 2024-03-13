package com.example.composeproject.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier

@Composable
fun TestLazyColumn(viewModel: VkNewsMainScreenViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val models = viewModel.models.observeAsState(listOf())
        LazyColumn {
            items(models.value) { instagramModel ->
                InstagramProfileCard(
                    model = instagramModel,
                    onFollowButtonClickListener = { viewModel.changeFollowStatus(instagramModel) })
            }
        }
    }
}