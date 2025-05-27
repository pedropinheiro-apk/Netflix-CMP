package com.codandotv.streamplayerapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.codandotv.streamplayerapp.StreamPlayerApp
import com.codandotv.streamplayerapp.feature_list_streams.list.data.ListStreamRepository
import com.google.firebase.Firebase
import com.google.firebase.initialize
import com.mmk.kmpnotifier.permission.permissionUtil
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {


    private val repository: ListStreamRepository by inject()
//    private val syncManager: SyncManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Firebase.initialize(this)
        requestNotificationPermission()
        setContent {
            StreamPlayerApp()
        }

        try {
            teste()
        } catch (e: Exception) {
            println("MainActivity: Erro ao testar SyncManager: ${e.message}")
        }
    }

    private fun requestNotificationPermission() {
        val permissionUtil by permissionUtil()
        permissionUtil.askNotificationPermission()
    }


    private fun teste() {
        lifecycleScope.launch {
            repository.topRatedStream().first().let {
                println("MainActivity: Top Rated Stream: ${it.name}")
            }
//            syncManager.syncData()
        }
    }
}
