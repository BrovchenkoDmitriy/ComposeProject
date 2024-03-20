package com.example.composeproject.testComposableFunctions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeproject.ui.theme.InstagramProfileCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestLazyColumn(viewModel: VkNewsMainScreenViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val models = viewModel.models.observeAsState(listOf())
//        val lazyListState = rememberLazyListState()
//        val scope = rememberCoroutineScope() // lazyListState.scrollToItem(...) - suspend, потому нужен scope
        LazyColumn (
//            state = lazyListState //для работы со стейтом списка(переход к нужному элементу, показать индекс первого видимого элемента и т.д.)
        ){

            items(models.value, key = { it.id }) { instagramModel ->
                val dismissState: DismissState =
                    rememberDismissState(
                        positionalThreshold = { _ -> 156.dp.toPx() } //устанавливаем насколько надо сдвинуть элемент для удаления
                    )
                if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                    viewModel.deleteModel(instagramModel)
                }

                SwipeToDismiss(
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
                        InstagramProfileCard(
                            model = instagramModel,
                            onFollowButtonClickListener = {
                                viewModel.changeFollowStatus(instagramModel)
//                                scope.launch{
//                                    lazyListState.scrollToItem(0)
//                                }
                            })
                    })
            }
        }
    }
}