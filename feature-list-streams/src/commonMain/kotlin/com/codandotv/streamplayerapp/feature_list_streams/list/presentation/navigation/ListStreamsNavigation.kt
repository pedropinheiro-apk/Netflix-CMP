@file:OptIn(KoinExperimentalAPI::class)

package com.codandotv.streamplayerapp.feature_list_streams.list.presentation.navigation

import androidx.annotation.UiThread
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.entry
import com.codandotv.streamplayerapp.core_navigation.routes.Routes
import com.codandotv.streamplayerapp.feature_list_streams.list.di.ListStreamModule
import com.codandotv.streamplayerapp.feature_list_streams.list.presentation.screens.ListStreamsScreen
import org.koin.compose.module.rememberKoinModules
import org.koin.core.annotation.KoinExperimentalAPI

fun EntryProviderBuilder<*>.homeScreen(
    navigateToDetails: (String) -> Unit = {},
    navigateToProfilePicker: () -> Unit = {},
    navigateToSearch: () -> Unit = {},
) = entry<Routes.Home> { key ->
    rememberKoinModules { listOf(ListStreamModule.module) }

    ListStreamsScreen(
        profilePicture = key.id,
        onNavigateDetailList = navigateToDetails,
        onNavigateSearchScreen = navigateToSearch,
        onNavigateProfilePicker = navigateToProfilePicker,
    )
}

@UiThread
fun MutableList<Routes>.navigateToHome(id: String = "") {
    add(Routes.Home(id = id))
}
