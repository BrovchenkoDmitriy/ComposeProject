package com.example.composeproject.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeproject.domain.InstagramModel
import kotlin.random.Random

class VkNewsMainScreenViewModel : ViewModel() {

    private val initList = mutableListOf<InstagramModel>().apply {
        repeat(100) {
            add(
                InstagramModel(
                    id = it,
                    tittle = "Tittle $it",
                    isFollowed = Random.nextBoolean()
                )
            )
        }
    }


    private val _models = MutableLiveData<List<InstagramModel>>(initList)
    val models: LiveData<List<InstagramModel>> = _models

    fun changeFollowStatus(model: InstagramModel) {
        val newList = models.value?.toMutableList() ?: mutableListOf()
        newList.replaceAll {
            if (it == model) {
                it.copy(isFollowed = !it.isFollowed)
            } else it
        }
        _models.value = newList
    }

    fun deleteModel(instagramModel: InstagramModel) {
        val newList = models.value?.toMutableList() ?: mutableListOf()
        newList.remove(instagramModel)
        _models.value = newList

    }
}