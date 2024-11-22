package com.example.composeproject.ui.theme

import com.example.composeproject.domain.FeedPost

sealed class FeedPostsScreenState {

    object Initial : FeedPostsScreenState()
    data class Posts(val posts: List<FeedPost>) : FeedPostsScreenState()
}