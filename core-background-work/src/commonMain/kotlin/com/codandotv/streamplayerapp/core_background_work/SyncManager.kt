package com.codandotv.streamplayerapp.core_background_work
import kotlinx.coroutines.delay

class SyncManager {
    suspend fun syncData() {
        NotifierHelperAndroid.showSimpleNotification("Sincronizando dados", "Sincronizando dados de teste...")
        println("SyncManager: BGTestes Sincronizando dados de teste...")
        delay(2000)
        println("SyncManager: BGTestes Dados sincronizados com sucesso!")
    }
}