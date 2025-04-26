package com.codandotv.streamplayerapp.core_camera_gallery.gallery

import androidx.compose.runtime.Composable
import com.codandotv.streamplayerapp.core_camera_gallery.SharedImage

expect class GalleryManager(
    onLaunch: () -> Unit
) {
    fun launch()
}
@Composable
expect fun rememberGalleryManager(onImageSelected: (SharedImage?) -> Unit): GalleryManager
