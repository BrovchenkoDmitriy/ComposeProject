package com.example.composeproject.testComposableFunctions

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeproject.ui.theme.NavigationItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainScreen() {
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    Log.d("blablabla", snackbarHostState.currentSnackbarData.toString())
    val scope = rememberCoroutineScope()
    var fabIsVisible by rememberSaveable {
        mutableStateOf(true)
    }
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
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            if (fabIsVisible) {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            val action =
                                snackbarHostState.showSnackbar("Hello", actionLabel = "Hide")
                            if (action == SnackbarResult.ActionPerformed) {
                                fabIsVisible = false
                            }
                        }
                    }) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = null)
                }
            }

        }
    ) {
        Text(
            modifier = Modifier.padding(it),
            text = "Some text"
        )
    }
}