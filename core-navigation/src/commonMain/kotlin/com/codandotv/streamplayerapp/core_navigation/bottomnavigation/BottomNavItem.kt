package com.codandotv.streamplayerapp.core_navigation.bottomnavigation

import com.codandotv.streamplayerapp.core_navigation.routes.Routes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import streamplayerapp_kmp.core_navigation.generated.resources.Res
import streamplayerapp_kmp.core_navigation.generated.resources.bottom_nav_downloads
import streamplayerapp_kmp.core_navigation.generated.resources.bottom_nav_games
import streamplayerapp_kmp.core_navigation.generated.resources.bottom_nav_home
import streamplayerapp_kmp.core_navigation.generated.resources.bottom_nav_news
import streamplayerapp_kmp.core_navigation.generated.resources.ic_downloads_selected
import streamplayerapp_kmp.core_navigation.generated.resources.ic_downloads_unselected
import streamplayerapp_kmp.core_navigation.generated.resources.ic_games_selected
import streamplayerapp_kmp.core_navigation.generated.resources.ic_games_unselected
import streamplayerapp_kmp.core_navigation.generated.resources.ic_home_selected
import streamplayerapp_kmp.core_navigation.generated.resources.ic_home_unselected
import streamplayerapp_kmp.core_navigation.generated.resources.ic_news_selected
import streamplayerapp_kmp.core_navigation.generated.resources.ic_news_unselected

enum class BottomNavItem(
    val screenRoute: Routes,
    val title: StringResource,
    val iconSelected: DrawableResource,
    val iconUnselected: DrawableResource,
) {
    Home(
        screenRoute = Routes.Home(""),
        title = Res.string.bottom_nav_home,
        iconSelected = Res.drawable.ic_home_selected,
        iconUnselected = Res.drawable.ic_home_unselected,
    ),
    Games(
        screenRoute = Routes.Games,
        title = Res.string.bottom_nav_games,
        iconSelected = Res.drawable.ic_games_selected,
        iconUnselected = Res.drawable.ic_games_unselected,
    ),
    News(
        screenRoute = Routes.News,
        title = Res.string.bottom_nav_news,
        iconSelected = Res.drawable.ic_news_selected,
        iconUnselected = Res.drawable.ic_news_unselected,
    ),
    Downloads(
        screenRoute = Routes.Downloads,
        title = Res.string.bottom_nav_downloads,
        iconSelected = Res.drawable.ic_downloads_selected,
        iconUnselected = Res.drawable.ic_downloads_unselected,
    );
}
