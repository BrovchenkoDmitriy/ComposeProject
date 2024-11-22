package com.example.composeproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeproject.domain.CommentPost
import com.example.composeproject.domain.FeedPost
import com.example.composeproject.ui.theme.CommentsScreenState
import com.example.composeproject.ui.theme.CommentsScreenState.Comments
import com.example.composeproject.ui.theme.FeedPostsScreenState.Posts
import com.example.composeproject.ui.theme.NavigationItem

class CommentsViewModel : ViewModel() {

    private val comments = mutableListOf<CommentPost>().apply {
        repeat(10) {
            add(CommentPost(id = it))
        }
    }

    private val initList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(
                FeedPost(id = it, communityName = "Tittle $it")
            )
        }
    }

    private val _selectedNavItem = MutableLiveData<NavigationItem>(NavigationItem.Home)
    val selectedNavItem: LiveData<NavigationItem> = _selectedNavItem

    fun selectItem(item: NavigationItem) {
        _selectedNavItem.value = item
    }

    private val initialState = Posts(posts = initList)
    private var savedState: CommentsScreenState? = CommentsScreenState.Initial

    private val _screenState = MutableLiveData<CommentsScreenState>(CommentsScreenState.Initial)
    val screenState: LiveData<CommentsScreenState> = _screenState

    fun showComments(feedPost: FeedPost) {
        savedState = screenState.value
        _screenState.value = Comments(feedPost = feedPost, comments = comments)
    }

    fun closeComments() {
        _screenState.value
    }
}