package com.codandotv.streamplayerapp.core_background_work
import kotlinx.coroutines.delay

class SyncManager {
    suspend fun syncData() {
        println("SyncManager: Sincronizando dados de teste...")
        delay(2000)
        println("SyncManager: Dados sincronizados com sucesso!")
    }
}