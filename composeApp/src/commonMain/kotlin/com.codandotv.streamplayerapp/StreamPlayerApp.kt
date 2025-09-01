package com.codandotv.streamplayerapp

import androidx.compose.runtime.Composable
import com.codandotv.streamplayerapp.core_shared_ui.theme.StreamPlayerTheme
import com.codandotv.streamplayerapp.navigation.NavigationGraph

@Composable
fun StreamPlayerApp() {
    StreamPlayerTheme {
        NavigationGraph()
    }
}
