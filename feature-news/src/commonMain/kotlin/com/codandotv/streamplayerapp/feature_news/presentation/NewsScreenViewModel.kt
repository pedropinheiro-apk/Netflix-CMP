package com.codandotv.streamplayerapp.feature_news.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codandotv.streamplayerapp.core_permission.permission.AppPermission
import com.codandotv.streamplayerapp.core_permission.permission.PermissionStatus
import com.codandotv.streamplayerapp.core_permission.permission.PermissionsManager
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class NewsScreenUiState(
    val showPermissionDialog: Boolean = false,
)

class NewsScreenViewModel(
    val permissionsManager: PermissionsManager
) : ViewModel() {
    private val _openCameraEvent = MutableSharedFlow<Unit>()
    val openCameraEvent: SharedFlow<Unit> = _openCameraEvent

    private val _openGalleryEvent = MutableSharedFlow<Unit>()
    val openGalleryEvent: SharedFlow<Unit> = _openGalleryEvent

    private val _uiState = MutableStateFlow(NewsScreenUiState())
    val uiState: StateFlow<NewsScreenUiState> = _uiState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        initialValue = _uiState.value
    )

    fun openCamera() {
        requestPermission(AppPermission.CAMERA) {
            viewModelScope.launch {
                _openCameraEvent.emit(Unit)
            }
        }
    }

    fun openGallery() {
        requestPermission(AppPermission.GALLERY) {
            viewModelScope.launch {
                _openGalleryEvent.emit(Unit)
            }
        }
    }

    fun requestPermission(
        vararg permissions: AppPermission = arrayOf(AppPermission.CAMERA, AppPermission.GALLERY),
        result: () -> Unit = {},
    ) {
        viewModelScope.launch {
            permissionsManager.request(
                permissions = permissions,
                blockDenied = {
                    _uiState.update { it.copy(showPermissionDialog = true) }
                },
                blockDeniedAlways = {
                    _uiState.update { it.copy(showPermissionDialog = true) }
                },
                blockSuccess = { statusMap ->
                    if (statusMap[AppPermission.CAMERA] == PermissionStatus.GRANTED ||
                        statusMap[AppPermission.GALLERY] == PermissionStatus.GRANTED
                    ) {
                        result.invoke()
                    }
                }
            )
        }
    }

    fun dismissPermissionDialog() {
        _uiState.update { it.copy(showPermissionDialog = false) }
    }

    fun goToSetting() {
        _uiState.update { it.copy(showPermissionDialog = false) }
        permissionsManager.openSettings()
    }
}
