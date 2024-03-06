package com.example.composeproject.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VkNewsMainScreenViewModel:ViewModel() {

    private val _isFollowing = MutableLiveData<Boolean>()
    val isFollowing: LiveData<Boolean> = _isFollowing

    fun changeFollowStatus(){
        val status = isFollowing.value?: false
        _isFollowing.value = !status
    }
}