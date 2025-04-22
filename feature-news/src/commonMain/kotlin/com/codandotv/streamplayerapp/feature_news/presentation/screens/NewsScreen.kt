package com.codandotv.streamplayerapp.feature_news.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.codandotv.streamplayerapp.core_navigation.bottomnavigation.StreamPlayerBottomNavigation
import com.codandotv.streamplayerapp.feature_news.presentation.NewsScreenViewModel
import com.codandotv.streamplayerapp.feature_news.presentation.widget.ImagePickerContent
import com.codandotv.streamplayerapp.core_permission.permission.PermissionDeniedDialog
import dev.icerock.moko.permissions.compose.BindEffect
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import streamplayerapp_kmp.feature_news.generated.resources.Res
import streamplayerapp_kmp.feature_news.generated.resources.select_image_subtitle
import streamplayerapp_kmp.feature_news.generated.resources.select_image_title


@Composable
fun NewsScreenContent(
    navController: NavController,
    viewModel: NewsScreenViewModel = koinViewModel()
){
    val uiState by viewModel.uiState.collectAsState()
    BindEffect(viewModel.permissionsManager.controller)

    LaunchedEffect(Unit){
        viewModel.requestPermission()
    }

    LaunchedEffect(uiState.shouldOpenCamera) {
        if (uiState.shouldOpenCamera) {
            viewModel.consumeEffectCamera()
        }
    }

    LaunchedEffect(uiState.shouldOpenGallery) {
        if (uiState.shouldOpenGallery) {
            viewModel.consumeEffectGallery()
        }
    }

    if (uiState.showPermissionDialog) {
        PermissionDeniedDialog(
            onDismiss = { viewModel.dismissPermissionDialog() },
            onSettingsClick = {
                viewModel.goToSetting()
            }
        )
    }

    NewsScreen(
        navController = navController,
        onClickCamera = {
            viewModel.openCamera()
        },
        onClickGallery = {
            viewModel.openGallery()
        })
}

@Composable
fun NewsScreen(
    navController: NavController,
    onClickCamera: () -> Unit,
    onClickGallery: () -> Unit,
    imageBitmap: ImageBitmap? = null
) {
    Scaffold(
        bottomBar = {
            StreamPlayerBottomNavigation(navController = navController)
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(Res.string.select_image_title),
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    Text(
                        text = stringResource(Res.string.select_image_subtitle),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    ImagePickerContent(
                        imageBitmap = imageBitmap,
                        onClickCamera = onClickCamera,
                        onClickGallery = onClickGallery
                    )
                }
            }
        }
    )
}
