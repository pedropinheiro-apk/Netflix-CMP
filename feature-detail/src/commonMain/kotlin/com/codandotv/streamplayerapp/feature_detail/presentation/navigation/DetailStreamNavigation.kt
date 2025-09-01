@file:OptIn(KoinExperimentalAPI::class)

package com.codandotv.streamplayerapp.feature_detail.presentation.navigation

import androidx.annotation.UiThread
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.entry
import com.codandotv.streamplayerapp.core_navigation.routes.Routes
import com.codandotv.streamplayerapp.feature_detail.di.DetailStreamModule
import com.codandotv.streamplayerapp.feature_detail.presentation.screens.DetailStreamScreen
import com.codandotv.streamplayerapp.feature_detail.presentation.screens.DetailStreamViewModel
import org.koin.compose.getKoin
import org.koin.compose.module.rememberKoinModules
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.parameter.parametersOf

fun EntryProviderBuilder<*>.detailsScreen(
    navigateToSearch: () -> Unit = {},
) = entry<Routes.Detail> { key ->
    rememberKoinModules { listOf(DetailStreamModule.module) }

    val viewModel = koinViewModel<DetailStreamViewModel> { parametersOf(key.id) }

    DetailStreamScreen(
        viewModel = viewModel,
        sharedHandlerPlatform = getKoin().get(),
        onNavigateSearchScreen = navigateToSearch,
    )
}

@UiThread
fun MutableList<Routes>.navigateToDetails(id: String) {
    add(Routes.Detail(id = id))
}
