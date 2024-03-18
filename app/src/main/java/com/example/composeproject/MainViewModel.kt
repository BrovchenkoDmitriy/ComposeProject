package com.example.composeproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeproject.domain.FeedPost
import com.example.composeproject.domain.StatisticItem
import com.example.composeproject.ui.theme.NavigationItem

class MainViewModel : ViewModel() {

    private val initList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(
                FeedPost(id = it, communityName = "Tittle $it")
            )
        }
    }

    private val _selectedNavItem = MutableLiveData<NavigationItem>(NavigationItem.Home)
    val selectedNavItem: LiveData<NavigationItem> = _selectedNavItem

    fun selectItem(item: NavigationItem){
        _selectedNavItem.value = item
    }

    private val _feedPosts = MutableLiveData<List<FeedPost>>(initList)
    val feedPosts: LiveData<List<FeedPost>> = _feedPosts

    private fun updateCount(feedPost: FeedPost, item: StatisticItem): FeedPost {
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else oldItem
            }
        }
        return feedPost.copy(statistics = newStatistics)
    }

    fun updateFeedPost(feedPost: FeedPost, item: StatisticItem) {
        val newList = feedPosts.value?.toMutableList() ?: mutableListOf()
        newList.replaceAll {
            if (it == feedPost) {
                updateCount(feedPost, item)
            } else it
        }
        _feedPosts.value = newList
    }

    fun deleteFeedPost(feedPost: FeedPost) {
        val newList = feedPosts.value?.toMutableList() ?: mutableListOf()
        newList.remove(feedPost)
        _feedPosts.value = newList
    }
}