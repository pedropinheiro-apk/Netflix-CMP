package com.codandotv.streamplayerapp.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.codandotv.streamplayerapp.core_navigation.bottomnavigation.LocalBackStackProvider
import com.codandotv.streamplayerapp.core_navigation.bottomnavigation.StreamPlayerBottomNavigation
import com.codandotv.streamplayerapp.core_navigation.routes.Routes
import com.codandotv.streamplayerapp.core_navigation.utils.pop
import com.codandotv.streamplayerapp.feature_detail.presentation.navigation.detailsScreen
import com.codandotv.streamplayerapp.feature_detail.presentation.navigation.navigateToDetails
import com.codandotv.streamplayerapp.feature_list_streams.list.presentation.navigation.homeScreen
import com.codandotv.streamplayerapp.feature_list_streams.list.presentation.navigation.navigateToHome
import com.codandotv.streamplayerapp.feature_news.presentation.navigation.newsScreen
import com.codandotv.streamplayerapp.feature_search.presentation.navigation.navigateToSearchScreen
import com.codandotv.streamplayerapp.feature_search.presentation.navigation.searchScreen
import com.codandotv.streamplayerapp.presentation.navigation.splashScreen
import com.codandotv.streamplayerapp.profile.presentation.navigation.navigateToProfilePicker
import com.codandotv.streamplayerapp.profile.presentation.navigation.profilePickerScreen

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
) {
    val backStack = remember { mutableStateListOf<Routes>(Routes.Splash) }

    CompositionLocalProvider(
        LocalBackStackProvider provides backStack,
    ) {
        NavDisplay(
            modifier = modifier,
            backStack = backStack,
            entryProvider = entryProvider {
                splashScreen(navigateForward = backStack::navigateToHome)
                newsScreen()
                homeScreen(
                    navigateToDetails = backStack::navigateToDetails,
                    navigateToSearch = backStack::navigateToSearchScreen,
                    navigateToProfilePicker = backStack::navigateToProfilePicker,
                )
                searchScreen(
                    onBackPressed = backStack::pop,
                    navigateToDetails = backStack::navigateToDetails,
                )
                profilePickerScreen(navigateToHome = backStack::navigateToHome)
                detailsScreen(navigateToSearch = backStack::navigateToSearchScreen)

                entry<Routes.Games> {
                    example(route = "Games")
                }

                entry<Routes.Downloads> {
                    example(route = "Downloads")
                }
            }
        )
    }
}

@Composable
fun example(route: String) {
    Scaffold(
        bottomBar = {
            StreamPlayerBottomNavigation()
        }
    ) { _ ->
        Text(text = route, color = Color.White)
    }
}
