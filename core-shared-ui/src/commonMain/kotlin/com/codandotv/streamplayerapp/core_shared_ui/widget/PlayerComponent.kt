@file:Suppress("EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE")

package com.codandotv.streamplayerapp.core_shared_ui.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun PlayerComponent(videoId: String, modifier: Modifier = Modifier)

