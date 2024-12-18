package detail.presentation.screens

import detail.domain.DetailStream

sealed class DetailStreamsUIState {
    data class DetailStreamsLoadedUIState(
        val detailStream: DetailStream,
        val videoId: String?,
    ) : DetailStreamsUIState()

    object LoadingStreamUIState : DetailStreamsUIState()
}
