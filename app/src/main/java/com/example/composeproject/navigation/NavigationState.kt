package com.example.composeproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
// создаем класс, который описывает навигацию
class NavigationState(
    val navHostController: NavHostController
) {
    fun navigateTo(route: String) {
        navHostController.navigate(route) {
            popUpTo(navHostController.graph.startDestinationId) {//при нажатии кнопки назад возвращаемся к стартовому экрану
                saveState = true
            }
            launchSingleTop = true //исключаем добавление в стек повторных экранов
            restoreState = true
        }
    }
}
//создаем composable функцию, которая будет возвращать NavigationState
@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState {
    return remember {
        NavigationState(navHostController)
    }
}