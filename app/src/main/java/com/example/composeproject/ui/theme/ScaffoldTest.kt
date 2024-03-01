package com.example.composeproject.ui.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TestScaffold() {
    val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(12.dp))
                items.forEach { item ->
                    NavigationDrawerItem(
                        selected = false,
                        onClick = {},
                        icon = { Icon(item, contentDescription = null) },
                        label = { Text(text = item.name) }
                    )
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "TittleTopBar") },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.Menu, contentDescription = null)
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Blue,
                        navigationIconContentColor = Color.White,
                        titleContentColor = Color.White
                    )
                )
            },
            bottomBar = {
                val menuItems = listOf("Favorite", "Profile", "Settings")
                NavigationBar(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                ) {
                    menuItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.Yellow,
                                selectedTextColor = Color.Yellow,
                                indicatorColor = Color.Blue,
                                unselectedIconColor = Color.White,
                                unselectedTextColor = Color.White
                            ),
                            selected = when (index) {
                                0 -> true
                                1 -> false
                                2 -> false
                                else -> false
                            },
                            label = { Text(text = item) },
                            onClick = { },
                            icon = {
                                when (index) {
                                    0 -> Icon(Icons.Filled.Favorite, contentDescription = null)
                                    1 -> Icon(Icons.Filled.AccountCircle, contentDescription = null)
                                    2 -> Icon(Icons.Filled.Build, contentDescription = null)
                                }
                            }
                        )
                    }
                }
            },

            ) {
            Text(
                modifier = Modifier.padding(it),
                text = "Some text"
            )
        }
    }

}