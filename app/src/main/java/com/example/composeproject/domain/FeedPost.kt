package com.example.composeproject.domain

import com.example.composeproject.R

data class FeedPost(
    val id:Int = 0,
    val communityName: String = "уволено",
    val publicationDate: String = "14:20",
    val avatarResId: Int = R.drawable.ic_launcher_foreground,
    val contentText: String = "Просто обычный текст, не несущий смысловой нагрузки и предназначенный для теста.",
    val contentImageResId: Int = R.drawable.ic_launcher_background,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, count = 206),
        StatisticItem(type = StatisticType.SHARES, 96),
        StatisticItem(type = StatisticType.COMMENTS, 57),
        StatisticItem(type = StatisticType.LIKES, 13),
    )

)