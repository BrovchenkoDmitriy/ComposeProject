package com.example.composeproject.ui.theme

import HomeScreen
import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composeproject.MainViewModel
import com.example.composeproject.navigation.AppNavGraph
import com.example.composeproject.navigation.rememberNavigationState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenNew(viewModel: MainViewModel) {
    val navigationState = rememberNavigationState()
    Scaffold(
        bottomBar = {
            val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            val items = listOf(
                NavigationItem.Home,
                NavigationItem.Favorite,
                NavigationItem.Profile
            )
            NavigationBar {
                items.forEach { navigationItem ->
                    NavigationBarItem(
                        selected = currentRoute == navigationItem.screen.route,
                        onClick = { navigationState.navigateTo(navigationItem.screen.route) },
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
        AppNavGraph(
            navHostController = navigationState.navHostController,
            homeScreenContent = { HomeScreen(viewModel) },
            favouriteScreenContent = {
                TextCounter(name = "Favorite")
            },
            profileScreenContent = {

            }
        )
    }
}

@Composable
private fun TextCounter(name: String) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    Text(
        modifier = Modifier.clickable { count++ },
        text = "$name Count: $count"
    )
}
