package com.example.composeproject.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composeproject.R
import com.example.composeproject.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val icon: ImageVector
) {
    object Home :
        NavigationItem(Screen.Home, R.string.navigation_item_home, Icons.Outlined.Home)

    object Favorite :
        NavigationItem(Screen.Favourite, R.string.navigation_item_favorite, Icons.Outlined.Favorite)

    object Profile :
        NavigationItem(Screen.Profile, R.string.navigation_item_profile, Icons.Outlined.Person)

}