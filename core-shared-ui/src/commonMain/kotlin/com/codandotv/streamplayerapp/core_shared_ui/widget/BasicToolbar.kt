package com.codandotv.streamplayerapp.core_shared_ui.widget

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicToolbar(
    title: String = "",
    onIconClicked: () -> Unit = {},
) {
    TopAppBar(
        title = { Text(text = title) },
        modifier = Modifier.height(56.dp),
        navigationIcon = {
            IconButton(onClick = onIconClicked) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        }
    )
}
