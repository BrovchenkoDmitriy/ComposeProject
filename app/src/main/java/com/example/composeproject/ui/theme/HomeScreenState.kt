package com.example.composeproject.ui.theme

import com.example.composeproject.domain.CommentPost
import com.example.composeproject.domain.FeedPost

sealed class HomeScreenState{

    object Initial: HomeScreenState()
    data class Posts(val posts: List<FeedPost>): HomeScreenState()
    data class Comments(val comments: List<CommentPost>, val feedPost: FeedPost): HomeScreenState()

}