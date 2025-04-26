//package com.codandotv.streamplayerapp.feature_news.presentation.widget
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.graphics.ImageBitmap
//import com.codandotv.streamplayerapp.core_camera_gallery.camera.rememberCameraManager
//import com.codandotv.streamplayerapp.core_shared_ui.permission.PermissionCallback
//import com.codandotv.streamplayerapp.core_shared_ui.permission.createPermissionsManager
//import kotlinx.coroutines.launch
//
//@Composable
//fun rememberImageCaptureHandler(
//    onImagePicked: (ImageBitmap) -> Unit
//): ImageCaptureHandler {
//    val coroutineScope = rememberCoroutineScope()
//
//    var launchCamera: Boolean by remember { mutableStateOf(false) }
//    var launchSettings: Boolean by remember { mutableStateOf(false) }
//    var showPermissionDialog: Boolean by remember { mutableStateOf(false) }
//
////
////    val permissionsManager =
////        createPermissionsManager(object : PermissionCallback {
////            override fun onPermissionStatus(
////                permissionType: PermissionType,
////                status: PermissionStatus
////            ) {
////                when (status) {
////                    PermissionStatus.GRANTED -> {
////                        when (permissionType) {
////                            PermissionType.CAMERA -> launchCamera = true
////                            PermissionType.GALLERY -> launchGallery = true
////                        }
////                    }
////
////                    else -> {
////                        showPermissionDialog = true
////                    }
////                }
////            }
////        })
////
////    val cameraManager = rememberCameraManager {
////        coroutineScope.launch {
////            it?.toImageBitmap()?.let { bitmap -> onImagePicked(bitmap) }
////        }
////    }
////
////    if (launchCamera) {
////        launchCamera = false
////        if (permissionsManager.isPermissionGranted(PermissionType.CAMERA)) {
////            cameraManager.launch()
////        } else {
////            permissionsManager.askPermission(PermissionType.CAMERA)
////        }
////    }
////
////    if (launchSettings) {
////        launchSettings = false
////        permissionsManager.launchSettings()
////    }
////
////    return remember {
////        ImageCaptureHandler(
////            onCameraRequest = { launchCamera = true },
////            onGalleryRequest = { launchGallery = true },
////            showSettings = { launchSettings = true },
////            showPermissionDialog = { showPermissionDialog },
////            hidePermissionDialog = { showPermissionDialog = false }
////        )
////    }
//}
