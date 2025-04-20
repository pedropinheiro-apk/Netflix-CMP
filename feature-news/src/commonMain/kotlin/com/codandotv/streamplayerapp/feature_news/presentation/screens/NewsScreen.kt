package com.codandotv.streamplayerapp.feature_news.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.codandotv.streamplayerapp.core_shared_ui.widget.BasicToolbar
import com.codandotv.streamplayerapp.feature_news.presentation.widget.ImagePickerContent
import org.jetbrains.compose.resources.stringResource
import streamplayerapp_kmp.feature_news.generated.resources.Res
import streamplayerapp_kmp.feature_news.generated.resources.select_image_subtitle
import streamplayerapp_kmp.feature_news.generated.resources.select_image_title


@Composable
fun NewsScreen(
    navController: NavController,
    onClickCamera: () -> Unit,
    onClickGallery: () -> Unit,
    imageBitmap: ImageBitmap? = null
) {
    Scaffold(
        topBar = {
            BasicToolbar(navController = navController)
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
