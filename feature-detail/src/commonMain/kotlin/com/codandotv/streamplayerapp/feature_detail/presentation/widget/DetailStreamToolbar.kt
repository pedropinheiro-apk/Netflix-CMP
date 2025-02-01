package com.codandotv.streamplayerapp.feature_detail.presentation.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import streamplayerapp_kmp.core_shared_ui.generated.resources.perfil_fake
import streamplayerapp_kmp.feature_detail.generated.resources.Res
import streamplayerapp_kmp.core_shared_ui.generated.resources.Res as SharedRes
import streamplayerapp_kmp.feature_detail.generated.resources.detail_back
import streamplayerapp_kmp.feature_detail.generated.resources.detail_search

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailStreamToolbar(
    navController: NavController,
    onNavigateSearchScreen: () -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = "") },
        modifier = Modifier.height(56.dp),
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(Res.string.detail_back)
                )
            }
        }, actions = {
            IconButton(onClick = {
                onNavigateSearchScreen.invoke()
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    tint = Color.White,
                    contentDescription = stringResource(Res.string.detail_search)
                )
            }
            IconButton(onClick = { }) {
                Image(
                    painter = painterResource(SharedRes.drawable.perfil_fake),
                    contentDescription = null
                )
            }
        })
}