package com.codandotv.streamplayerapp.core_background_work

import com.codandotv.streamplayerapp.feature_list_streams.list.data.ListStreamRepository
import com.codandotv.streamplayerapp.feature_list_streams.list.domain.model.Stream
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first

class SyncManager(
    private val repository: ListStreamRepository
) {
    suspend fun syncData() {

        val titlle: Stream = repository.topRatedStream().first()

        val titleName = titlle.name
        val titleDescription = titlle.description
        val messageTitle = "$titleName -Já disponível no app!"
        val messageBody = "Confira a sinopse: $titleDescription"
        val imageUrl = "https://example.com/image.jpg"

        NotifierHelperAndroid.showSimpleNotification(
            title = messageTitle,
            body = messageBody,
            imageUrl = imageUrl
        )

        println("SyncManager: BGTestes Sincronizando dados de teste...")
        delay(2000)
        println("SyncManager: BGTestes Dados sincronizados com sucesso!")
    }
}