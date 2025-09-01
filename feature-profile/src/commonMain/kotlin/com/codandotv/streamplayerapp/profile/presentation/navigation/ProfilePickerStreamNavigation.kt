@file:OptIn(KoinExperimentalAPI::class)

package com.codandotv.streamplayerapp.profile.presentation.navigation

import androidx.annotation.UiThread
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.entry
import com.codandotv.streamplayerapp.core_navigation.routes.Routes
import com.codandotv.streamplayerapp.profile.di.ProfilePickerStreamModule
import com.codandotv.streamplayerapp.profile.presentation.screens.ProfilePickerStreamScreen
import org.koin.compose.module.rememberKoinModules
import org.koin.core.annotation.KoinExperimentalAPI

fun EntryProviderBuilder<*>.profilePickerScreen(
    navigateToHome: (String) -> Unit = {},
) = entry<Routes.ProfilePicker> {
    rememberKoinModules { listOf(ProfilePickerStreamModule.module) }

    ProfilePickerStreamScreen(onNavigateListStreams = navigateToHome)
}

@UiThread
fun MutableList<Routes>.navigateToProfilePicker() {
    add(Routes.ProfilePicker)
}
