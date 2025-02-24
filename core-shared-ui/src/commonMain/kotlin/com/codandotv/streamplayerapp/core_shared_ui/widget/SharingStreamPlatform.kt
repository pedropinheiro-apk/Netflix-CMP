package com.codandotv.streamplayerapp.core_shared_ui.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun SharingStreamPlatform(
    modifier : Modifier = Modifier,
    contentTitle: String,
    contentUrl: String,
    setShowDialog: (Boolean) -> Unit
)