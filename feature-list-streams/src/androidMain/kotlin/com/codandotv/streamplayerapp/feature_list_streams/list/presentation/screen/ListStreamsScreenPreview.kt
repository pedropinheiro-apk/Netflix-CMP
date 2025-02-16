package com.codandotv.streamplayerapp.feature_list_streams.list.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.codandotv.streamplayerapp.core_shared_ui.theme.ThemePreviews
import com.codandotv.streamplayerapp.feature_list_streams.list.presentation.screens.ListStreamsScreen

@ThemePreviews
@Composable
fun ListStreamsScreenPreview() {
    ListStreamsScreen(navController = rememberNavController(), profilePicture = "")
}
