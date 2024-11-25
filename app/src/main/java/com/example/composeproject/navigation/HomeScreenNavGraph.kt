package com.example.composeproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

fun NavGraphBuilder.homeScreenNavGraph(
    feedPostsScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable () -> Unit,
){
    navigation(
        startDestination = Screen.NewsFeed.route,
        route = Screen.Home.route

    ){
        composable(Screen.NewsFeed.route){
            feedPostsScreenContent()
        }
        composable(Screen.Comments .route){
            commentsScreenContent()
        }
    }
}