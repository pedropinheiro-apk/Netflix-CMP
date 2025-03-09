package com.codandotv.streamplayerapp.core_shared_ui.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharingStreamPlatform(
    contentTitle: String,
    contentUrl: String,
    setShowDialog: (Boolean) -> Unit,
    shareHandler: SharedHandlerPlatform
) {
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = { setShowDialog(false) },
        sheetState = bottomSheetState,
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Compartilhar", fontSize = 18.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        shareHandler.shareWhatsApp(contentTitle, contentUrl)
                        coroutineScope.launch { setShowDialog(false) }
                    }
                    .padding(12.dp)
            ) {
                Text("WhatsApp", fontSize = 18.sp, color = Color.Black)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        shareHandler.shareSms(contentTitle, contentUrl)
                        coroutineScope.launch { setShowDialog(false) }
                    }
                    .padding(12.dp)
            ) {
                Text("SMS", fontSize = 18.sp, color = Color.Black)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        shareHandler.copyToClipboard(contentUrl)
                        coroutineScope.launch { setShowDialog(false) }
                    }
                    .padding(12.dp)
            ) {
                Text("Copiar Link", fontSize = 18.sp, color = Color.Black)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        shareHandler.shareMoreOptions(contentTitle, contentUrl)
                        coroutineScope.launch { setShowDialog(false) }
                    }
                    .padding(12.dp)
            ) {
                Text("Mais opções", fontSize = 18.sp, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            bottomSheetState.show()
        }
    }
}
