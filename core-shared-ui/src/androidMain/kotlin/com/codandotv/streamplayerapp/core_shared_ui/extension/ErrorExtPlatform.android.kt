package com.codandotv.streamplayerapp.core_shared_ui.extension

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun ShowErrorMessage(errorMessage: String) {
    Toast.makeText(LocalContext.current,errorMessage,Toast.LENGTH_SHORT).show()
}