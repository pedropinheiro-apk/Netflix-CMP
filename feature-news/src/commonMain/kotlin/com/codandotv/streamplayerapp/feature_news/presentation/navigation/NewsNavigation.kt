@file:OptIn(KoinExperimentalAPI::class)

package com.codandotv.streamplayerapp.feature_news.presentation.navigation

import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.entry
import com.codandotv.streamplayerapp.core_navigation.routes.Routes
import com.codandotv.streamplayerapp.feature_news.di.NewsScreenModule
import com.codandotv.streamplayerapp.feature_news.presentation.screens.NewsScreenContent
import org.koin.compose.module.rememberKoinModules
import org.koin.core.annotation.KoinExperimentalAPI

fun EntryProviderBuilder<*>.newsScreen() = entry<Routes.News> { key ->
    rememberKoinModules {
        listOf(NewsScreenModule.module, PermissionsModule.module)
    }

    NewsScreenContent()
}
