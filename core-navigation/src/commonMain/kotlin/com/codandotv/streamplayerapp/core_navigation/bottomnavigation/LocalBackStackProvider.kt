package com.codandotv.streamplayerapp.core_navigation.bottomnavigation

import androidx.compose.runtime.compositionLocalOf
import com.codandotv.streamplayerapp.core_navigation.routes.Routes

val LocalBackStackProvider = compositionLocalOf<MutableList<Routes>> {
    error("No BackStackProvider provided")
}
