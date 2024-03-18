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
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composeproject.MainViewModel
import com.example.composeproject.navigation.AppNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenNew(viewModel: MainViewModel) {
    val navHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
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
                        onClick = { navHostController.navigate(navigationItem.screen.route) },
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
            navHostController = navHostController,
            homeScreenContent = { HomeScreen(viewModel) },
            favouriteScreenContent = { Text(text = "Favorite") },
            profileScreenContent = { Text(text = "Profile") }
        )
    }
}
