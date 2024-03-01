package com.example.composeproject.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composeproject.R

sealed class NavigationItem(
    val titleResId:Int,
    val icon:ImageVector
) {
    object Home: NavigationItem(R.string.navigation_item_home,  Icons.Outlined.Home)
    object Favorite: NavigationItem(R.string.navigation_item_favorite,  Icons.Outlined.Favorite)
    object Profile: NavigationItem(R.string.navigation_item_profile,  Icons.Outlined.Person)

}