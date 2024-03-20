package com.example.composeproject.domain

import com.example.composeproject.R

class CommentPost (
    val id: Int,
    val authorName: String ="Author",
    val authorAvatarId: Int = R.drawable.ic_launcher_background,
    val commentText:String ="Long comment text",
    val publicationDate: String ="14:00"
)