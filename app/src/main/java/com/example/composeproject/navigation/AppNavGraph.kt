package com.example.composeproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    feedPostsScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable () -> Unit,
    favouriteScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit

    ) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route,
    )
    {

        homeScreenNavGraph(
            feedPostsScreenContent = feedPostsScreenContent,
            commentsScreenContent = commentsScreenContent
        )

        composable(Screen.Favourite.route) {
            favouriteScreenContent()
        }

        composable(Screen.Profile.route) {
            profileScreenContent()
        }

    }
}