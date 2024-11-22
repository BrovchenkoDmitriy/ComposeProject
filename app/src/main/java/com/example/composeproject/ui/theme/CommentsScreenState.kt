package com.example.composeproject.ui.theme

import com.example.composeproject.domain.CommentPost
import com.example.composeproject.domain.FeedPost

sealed class CommentsScreenState {

    object Initial : CommentsScreenState()
    data class Comments(val comments: List<CommentPost>, val feedPost: FeedPost) : CommentsScreenState()
}