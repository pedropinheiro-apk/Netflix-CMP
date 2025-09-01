package com.codandotv.streamplayerapp.presentation.navigation

import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.entry
import com.codandotv.streamplayerapp.core_navigation.routes.Routes
import com.codandotv.streamplayerapp.presentation.screens.SplashScreen

fun EntryProviderBuilder<*>.splashScreen(
    navigateForward: () -> Unit = {},
) = entry<Routes.Splash> {
    SplashScreen(onAnimationFinished = navigateForward)
}
