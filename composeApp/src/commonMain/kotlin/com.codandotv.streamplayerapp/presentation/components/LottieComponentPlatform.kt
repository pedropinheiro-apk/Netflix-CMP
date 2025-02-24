package com.codandotv.streamplayerapp.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun LottieComponent(modifier : Modifier = Modifier, onAnimationFinished: () -> Unit)