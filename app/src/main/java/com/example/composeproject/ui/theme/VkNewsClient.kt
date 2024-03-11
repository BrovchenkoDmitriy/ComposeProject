package com.example.composeproject.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.composeproject.R
import com.example.composeproject.domain.FeedPost
import com.example.composeproject.domain.StatisticItem
import com.example.composeproject.domain.StatisticType

@Composable
fun VkNewsCard(
    modifier: Modifier = Modifier,
    feedPost: FeedPost,
    onStatisticsItemClickListener: (StatisticItem) -> Unit

) {
    Card(
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        border = BorderStroke(1.dp, Color.LightGray),
        modifier = Modifier.padding(4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeadOfVkNewsCard(feedPost)
            Text(
                text = feedPost.contentText,
                modifier = Modifier.padding(8.dp)
            )
            Image(
                painter = painterResource(id = feedPost.contentImageResId),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(R.string.content),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(200.dp)
            )
            StatisticsOfVkNewsCard(
                feedPost.statistics,
                onItemClickListener = onStatisticsItemClickListener
            )
        }
    }
}

@Composable
private fun HeadOfVkNewsCard(feedPost: FeedPost) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        VkAvatar(feedPost)
        Spacer(modifier = Modifier.width(4.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = feedPost.communityName)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = feedPost.publicationDate)
        }
        MenuButton(Icons.Rounded.MoreVert)
    }
}

@Composable
private fun StatisticsOfVkNewsCard(
    statistics: List<StatisticItem>,
    onItemClickListener: (StatisticItem) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val viewsItem = statistics.getItemByType(StatisticType.VIEWS)
        Statistics(
            viewsItem.count.toString(),
            R.drawable.ic_views,
            onItemClickListener = { onItemClickListener(viewsItem) }
        )
        Spacer(Modifier.weight(1f, true))
        val sharesItem = statistics.getItemByType(StatisticType.SHARES)
        Statistics(
            sharesItem.count.toString(),
            R.drawable.ic_share,
            onItemClickListener = { onItemClickListener(sharesItem) }
        )
        val commentsItem = statistics.getItemByType(StatisticType.COMMENTS)
        Statistics(
            commentsItem.count.toString(),
            R.drawable.ic_comments,
            onItemClickListener = { onItemClickListener(commentsItem) }
        )
        val likesItem = statistics.getItemByType(StatisticType.LIKES)
        Statistics(
            likesItem.count.toString(),
            R.drawable.ic_chosen,
            onItemClickListener = { onItemClickListener(likesItem) }
        )
    }
}

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
    return this.find { it.type == type } ?: throw IllegalStateException("Not exist type")
}

@Composable
private fun VkAvatar(feedPost: FeedPost) {
    Image(
        modifier = Modifier
            .size(50.dp)
            .background(MaterialTheme.colorScheme.background)
            .clip(CircleShape)
            .paint
                (
                painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.Inside,
            ),
        painter = painterResource(id = feedPost.avatarResId),
        contentDescription = stringResource(R.string.instagram_logo),
        contentScale = ContentScale.Inside,

        )
}

@Composable
private fun MenuButton(id: ImageVector) {
    IconButton(
        onClick = { /*TODO*/ },
        content = {
            Icon(
                imageVector = id,
                contentDescription = stringResource(R.string.menu)
            )
        }
    )
}

@Composable
private fun Statistics(
    value: String,
    @DrawableRes id: Int,
    onItemClickListener: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onItemClickListener() },

        ) {
        Icon(
            painter = painterResource(id),
            contentDescription = stringResource(R.string.bottom_menu)
        )
        Text(text = value)
    }
}


