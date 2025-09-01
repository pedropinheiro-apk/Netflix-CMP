package com.codandotv.streamplayerapp.core_navigation.routes

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object Splash : Routes

    @Serializable
    data object Search : Routes

    @Serializable
    data object ProfilePicker : Routes

    @Serializable
    data class Detail(val id: String) : Routes

    @Serializable
    data class Home(val id: String) : Routes

    @Serializable
    data object Games : Routes

    @Serializable
    data object News : Routes

    @Serializable
    data object Downloads : Routes
}
