@file:OptIn(KoinExperimentalAPI::class)

package com.codandotv.streamplayerapp.feature_search.presentation.navigation

import androidx.annotation.UiThread
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.entry
import com.codandotv.streamplayerapp.core_navigation.routes.Routes
import com.codandotv.streamplayerapp.feature_search.di.SearchModule
import com.codandotv.streamplayerapp.feature_search.presentation.screens.SearchScreen
import org.koin.compose.module.rememberKoinModules
import org.koin.core.annotation.KoinExperimentalAPI

fun EntryProviderBuilder<*>.searchScreen(
    onBackPressed: () -> Unit = {},
    navigateToDetails: (String) -> Unit = {},
) = entry<Routes.Search> {
    rememberKoinModules { listOf(SearchModule.module) }

    SearchScreen(
        onBackPressed = onBackPressed,
        onNavigateDetailList = navigateToDetails,
    )
}

@UiThread
fun MutableList<Routes>.navigateToSearchScreen() {
    add(Routes.Search)
}
