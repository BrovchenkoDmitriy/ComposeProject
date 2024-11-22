package com.example.composeproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeproject.domain.CommentPost
import com.example.composeproject.domain.FeedPost
import com.example.composeproject.ui.theme.CommentsScreenState
import com.example.composeproject.ui.theme.CommentsScreenState.Comments

class CommentsViewModel(feedPost: FeedPost) : ViewModel() {

    private val _screenState = MutableLiveData<CommentsScreenState>(CommentsScreenState.Initial)
    val screenState: LiveData<CommentsScreenState> = _screenState

    init {
        loadComments(feedPost)
    }

    fun loadComments(feedPost: FeedPost) {
        val comments = mutableListOf<CommentPost>().apply {
            repeat(10) {
                add(CommentPost(id = it))
            }
        }
        _screenState.value = Comments(feedPost = feedPost, comments = comments)
    }
}