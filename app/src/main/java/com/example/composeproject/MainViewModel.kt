package com.example.composeproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeproject.domain.CommentPost
import com.example.composeproject.domain.FeedPost
import com.example.composeproject.domain.StatisticItem
import com.example.composeproject.ui.theme.HomeScreenState
import com.example.composeproject.ui.theme.HomeScreenState.Comments
import com.example.composeproject.ui.theme.HomeScreenState.Posts
import com.example.composeproject.ui.theme.NavigationItem

class MainViewModel : ViewModel() {

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
    private var savedState: HomeScreenState? = initialState

    private val _screenState = MutableLiveData<HomeScreenState>(initialState)
    val screenState: LiveData<HomeScreenState> = _screenState

    fun updateCount(feedPost: FeedPost, item: StatisticItem) {
        val currentState = screenState.value
        if (currentState !is Posts) return

        val oldPosts = currentState.posts.toMutableList()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }

        val newFeedPost = feedPost.copy(statistics = newStatistics)
        val newPosts = oldPosts.apply {
            replaceAll {
                if (it == feedPost) {
                    newFeedPost
                } else {
                    it
                }
            }

        }
        _screenState.value = Posts(posts = newPosts)
    }

    fun deleteFeedPost(feedPost: FeedPost) {
        val currentState = screenState.value
        if (currentState !is Posts) return
        val newList = currentState.posts.toMutableList()
        newList.remove(feedPost)
        _screenState.value = Posts(posts = newList)
    }

    fun showComments(feedPost: FeedPost) {
        savedState = screenState.value
        _screenState.value = Comments(feedPost = feedPost, comments = comments)
    }

    fun closeComments() {
        _screenState.value = savedState
    }
}