package com.example.composeproject.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenNew(viewModel: MainViewModel) {


    Scaffold(
        bottomBar = {
            val items = listOf(
                NavigationItem.Home,
                NavigationItem.Favorite,
                NavigationItem.Profile
            )
            NavigationBar {
                val selectedPosition = rememberSaveable {
                    mutableStateOf(0)
                }
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedPosition.value,
                        onClick = { selectedPosition.value = index },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null
                            )
                        },
                        label = { Text(text = stringResource(id = item.titleResId)) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            indicatorColor = MaterialTheme.colorScheme.inverseOnSurface,
                            unselectedIconColor = MaterialTheme.colorScheme.secondary,
                            unselectedTextColor = MaterialTheme.colorScheme.secondary
                        ),
                    )
                }
            }
        }
    ) {
        LazyColumnFeedPosts(viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun LazyColumnFeedPosts(viewModel: MainViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val models = viewModel.feedPosts.observeAsState(listOf())
        LazyColumn(
            contentPadding = PaddingValues(
                top = 16.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 90.dp
            ), verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(models.value, key = { it.id }) { feedPost ->
                val dismissState: DismissState =
                    rememberDismissState(
                        positionalThreshold = { _ -> 156.dp.toPx() } //устанавливаем насколько надо cдвинуть элемент для удаления
                    )
                if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                    viewModel.deleteFeedPost(feedPost)
                }

                SwipeToDismiss(
                    modifier = Modifier.animateItemPlacement(),
                    state = dismissState,
                    directions = setOf(DismissDirection.EndToStart),
                    background = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                                .background(Color.Red.copy(alpha = 0.5f)),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Text(
                                text = "Delete Item",
                                color = Color.White,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    },
                    dismissContent = {
                        VkNewsCard(
                            feedPost = feedPost,
                            onItemViewClickListener =
                            {
                                viewModel.updateFeedPost(feedPost, it)
                            },
                            onItemShareClickListener = {
                                viewModel.updateFeedPost(feedPost, it)
                            },
                            onItemCommentClickListener = {
                                viewModel.updateFeedPost(feedPost, it)
                            },
                            onItemLikeClickListener = {
                                viewModel.updateFeedPost(feedPost, it)
                            }
                        )
                    })
            }
        }
    }
}
