package com.codandotv.streamplayerapp.core_navigation.bottomnavigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.codandotv.streamplayerapp.core.navigation.R
import com.codandotv.streamplayerapp.core_navigation.routes.BottomNavRoutes
import org.jetbrains.compose.resources.StringResource
import streamplayerapp_kmp.core_navigation.generated.resources.Res
import streamplayerapp_kmp.core_navigation.generated.resources.bottom_nav_downloads
import streamplayerapp_kmp.core_navigation.generated.resources.bottom_nav_games
import streamplayerapp_kmp.core_navigation.generated.resources.bottom_nav_home
import streamplayerapp_kmp.core_navigation.generated.resources.bottom_nav_news

sealed class BottomNavItem(
    var title: StringResource,
    @DrawableRes var iconUnselected: Int,
    @DrawableRes var iconSelected: Int,
    var screenRoute: String
) {
    object Home :
        BottomNavItem(
            Res.string.bottom_nav_home,
            R.drawable.ic_home_unselected,
            R.drawable.ic_home_selected,
            BottomNavRoutes.HOME
        )

    object Games :
        BottomNavItem(
            Res.string.bottom_nav_games,
            R.drawable.ic_games_unselected,
            R.drawable.ic_games_selected,
            BottomNavRoutes.GAMES
        )

    object News :
        BottomNavItem(
            Res.string.bottom_nav_news,
            R.drawable.ic_news_unselected,
            R.drawable.ic_news_selected,
            BottomNavRoutes.NEWS
        )

    object Downloads : BottomNavItem(
        Res.string.bottom_nav_downloads,
        R.drawable.ic_downloads_unselected,
        R.drawable.ic_downloads_selected,
        BottomNavRoutes.DOWNLOADS
    )
}