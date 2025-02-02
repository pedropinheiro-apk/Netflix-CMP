package com.codandotv.streamplayerapp.feature_search.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codandotv.streamplayerapp.core.shared.ui.R
import com.codandotv.streamplayerapp.core_shared_ui.resources.Colors
import com.codandotv.streamplayerapp.core_shared_ui.widget.CloseButton
import com.codandotv.streamplayerapp.core_shared_ui.widget.MicButton
import com.codandotv.streamplayerapp.core_shared_ui.widget.SearchIcon
import org.jetbrains.compose.resources.stringResource
import streamplayerapp_kmp.core_shared_ui.generated.resources.*
import streamplayerapp_kmp.feature_search.generated.resources.Res
import streamplayerapp_kmp.core_shared_ui.generated.resources.Res as SharedRes
import streamplayerapp_kmp.feature_search.generated.resources.search_list_main_search

@Suppress("LongParameterList")
@Composable
fun SearchableTopBar(
    currentSearchText: String,
    onSearchTextChanged: (String) -> Unit,
    onSearchDispatched: () -> Unit,
    onSearchIconPressed: () -> Unit,
    onBackPressed: () -> Unit,
    onCleanTextPressed: () -> Unit
) {
    Column {
        StreamPlayerTopBar(
            onBackPressed = onBackPressed
        )
        SearchTopBar(
            currentSearchText = currentSearchText,
            onSearchTextChanged = onSearchTextChanged,
            onSearchDispatched = onSearchDispatched,
            onCleanTextPressed = onCleanTextPressed,
            onSearchIconPressed = onSearchIconPressed
        )
    }
}

@Composable
private fun StreamPlayerTopBar(
    onBackPressed: () -> Unit
) {
    Row(
        modifier = Modifier
            .height(56.dp)
    ) {
        IconButton(
            modifier = Modifier.fillMaxHeight(),
            onClick = {
                onBackPressed()
            }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(SharedRes.string.icon_back),
                tint = Color.White,
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            modifier = Modifier.fillMaxHeight(),
            onClick = { /* todo */ }
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = stringResource(SharedRes.string.icon_cast),
                tint = Color.White,
            )
        }

        IconButton(
            modifier = Modifier.fillMaxHeight(),
            onClick = { /* todo */ }
        ) {
            Icon(
                modifier = Modifier
                    .height(24.dp)
                    .clip(RoundedCornerShape(4.dp)),
                painter = painterResource(R.drawable.perfil_fake),
                contentDescription = stringResource(SharedRes.string.icon_profile),
                tint = Color.Unspecified,
            )
        }
    }
}

@Composable
fun SearchTopBar(
    currentSearchText: String,
    onSearchTextChanged: (String) -> Unit,
    onSearchDispatched: () -> Unit,
    onCleanTextPressed: () -> Unit,
    onSearchIconPressed: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Colors.Gray100)
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = currentSearchText,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Colors.Gray100,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Gray
            ),
            onValueChange = {
                onSearchTextChanged(it)
            },
            placeholder = {
                Text(
                    text = stringResource(Res.string.search_list_main_search),
                    color = Color.Gray
                )
            },
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = Color.White
            ),
            singleLine = true,
            maxLines = 1,
            leadingIcon = {
                SearchIcon(action = onSearchIconPressed)
            },
            trailingIcon = {
                if (currentSearchText.isEmpty()) MicButton() else CloseButton(
                    action = onCleanTextPressed
                )
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                onSearchDispatched()
            }),
        )
    }
}


@Composable
@Preview
fun SearchBarPreview() {
    StreamPlayerTopBar(
        onBackPressed = {}
    )
}

@Composable
@Preview
fun SearchTopBarEmptyPreview() {
    SearchTopBar(
        currentSearchText = "",
        onSearchTextChanged = {},
        onSearchDispatched = {},
        onCleanTextPressed = {},
        onSearchIconPressed = {}
    )
}

@Composable
@Preview
fun SearchTopBarPreview() {
    SearchTopBar(
        currentSearchText = "Texto de busca",
        onSearchTextChanged = {},
        onSearchDispatched = {},
        onCleanTextPressed = {},
        onSearchIconPressed = {}
    )
}
