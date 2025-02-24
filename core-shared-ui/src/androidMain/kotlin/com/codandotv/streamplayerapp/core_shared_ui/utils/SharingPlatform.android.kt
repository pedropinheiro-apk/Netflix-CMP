package com.codandotv.streamplayerapp.core_shared_ui.utils

import android.content.pm.PackageManager
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.codandotv.streamplayerapp.core_shared_ui.extension.getPackageInfoCompat

@Composable
actual fun isPackageInstalled(packageName: String): Boolean {
    val pm = LocalContext.current.packageManager
    return try {
        pm.getPackageInfoCompat(packageName)
        true
    } catch (e: PackageManager.NameNotFoundException) {
        false
    }
}