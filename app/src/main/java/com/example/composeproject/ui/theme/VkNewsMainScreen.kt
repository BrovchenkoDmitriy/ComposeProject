package com.example.composeproject.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainScreen() {
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
                items.forEachIndexed {index, item ->
                    NavigationBarItem(
                        selected = index==selectedPosition.value,
                        onClick = {selectedPosition.value = index},
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
        Text(
            modifier = Modifier.padding(it),
            text = "Some text"
        )
    }
}