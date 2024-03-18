package com.example.composeproject.ui.theme

import HomeScreen
import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import com.example.composeproject.MainViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenNew(viewModel: MainViewModel) {

    val selectedPosition = viewModel.selectedNavItem.observeAsState(NavigationItem.Home)

    Scaffold(
        bottomBar = {
            val items = listOf(
                NavigationItem.Home,
                NavigationItem.Favorite,
                NavigationItem.Profile
            )
            NavigationBar {
                items.forEach { navigationItem ->
                    NavigationBarItem(
                        selected = selectedPosition.value == navigationItem,
                        onClick = { viewModel.selectItem(navigationItem) },
                        icon = {
                            Icon(
                                imageVector = navigationItem.icon,
                                contentDescription = null
                            )
                        },
                        label = { Text(text = stringResource(id = navigationItem.titleResId)) },
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
        when (selectedPosition.value) {
            NavigationItem.Home -> HomeScreen(viewModel)
            NavigationItem.Profile -> Text(text = "Profile")
            NavigationItem.Favorite -> Text(text = "Favorite")
        }
    }
}
