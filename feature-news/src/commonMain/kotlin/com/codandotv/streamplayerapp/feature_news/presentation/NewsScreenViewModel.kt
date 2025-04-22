package com.codandotv.streamplayerapp.feature_news.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codandotv.streamplayerapp.core_permission.permission.AppPermission
import com.codandotv.streamplayerapp.core_permission.permission.PermissionStatus
import com.codandotv.streamplayerapp.core_permission.permission.PermissionsManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class NewsScreenUiState(
    val showPermissionDialog: Boolean = false,
    val shouldOpenCamera: Boolean = false,
    val shouldOpenGallery: Boolean = false,
)

class NewsScreenViewModel(
    val permissionsManager: PermissionsManager
) : ViewModel() {

    private val _uiState = MutableStateFlow(NewsScreenUiState())
    val uiState: StateFlow<NewsScreenUiState> = _uiState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        initialValue = _uiState.value
    )

    init {
        requestPermission()
    }

    fun openCamera() {
        requestPermission(AppPermission.CAMERA) {
            _uiState.value = _uiState.value.copy(shouldOpenCamera = true)
        }
    }

    fun openGallery() {
        requestPermission(AppPermission.GALLERY) {
            _uiState.value = _uiState.value.copy(shouldOpenGallery = true)
        }
    }

    private fun requestPermission(
        vararg permission: AppPermission = arrayOf(AppPermission.CAMERA,AppPermission.GALLERY),
        result : () -> Unit = {},
    ) {
        viewModelScope.launch {
            permissionsManager.request(
                permissions = permission,
                blockDenied = {
                    _uiState.value = _uiState.value.copy(showPermissionDialog = true)
                },
                blockDeniedAlways = {
                    _uiState.value = _uiState.value.copy(showPermissionDialog = true)
                },
                blockSuccess = { statusMap ->
                    if (statusMap[AppPermission.CAMERA] == PermissionStatus.GRANTED ||
                        statusMap[AppPermission.GALLERY] == PermissionStatus.GRANTED) {
                        result.invoke()
                    }
                }
            )
        }
    }

    fun consumeEffectCamera() {
        _uiState.value = _uiState.value.copy(
            shouldOpenCamera = false,
        )
    }

    fun consumeEffectGallery() {
        _uiState.value = _uiState.value.copy(
            shouldOpenGallery = false,
        )
    }

    fun dismissPermissionDialog() {
        _uiState.value = _uiState.value.copy(showPermissionDialog = false)
    }

    fun goToSetting() {
        _uiState.value = _uiState.value.copy(showPermissionDialog = false)
        permissionsManager.openSettings()
    }
}
