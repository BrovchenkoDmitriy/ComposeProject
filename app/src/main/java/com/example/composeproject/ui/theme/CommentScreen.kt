package com.example.composeproject.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeproject.domain.CommentPost
import com.example.composeproject.domain.FeedPost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentScreen(
    feedPost: FeedPost,
    comments: List<CommentPost>,
    onBackPress: () -> Unit,
) {
    Scaffold(
        topBar = {
            Surface(shadowElevation = 4.dp) {
                TopAppBar(
                    title = {
                        Text(
                            text = "Comment for FeedPost Id: ${feedPost.id}"
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBackPress) {
                            Icon(
                                Icons.Filled.ArrowBack,
                                contentDescription = null
                            )
                        }
                    },
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(
                top = 4.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 80.dp
            )
        ) {
            items(comments, key = { it.id }) { commentPost ->
                CommentItem(commentPost = commentPost)
            }
        }
    }
}

@Composable
fun CommentItem(commentPost: CommentPost) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = commentPost.authorAvatarId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(4.dp))
        Column {
            Text(
                text = "${commentPost.authorName} CommentId: ${commentPost.id}",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 12.sp,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = commentPost.commentText,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = commentPost.publicationDate,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 12.sp,
            )
        }
    }
}

@Preview
@Composable
private fun TestPreview() {
    CommentItem(commentPost = CommentPost(0))
}

