package feature_detail.fake

import com.codandotv.streamplayerapp.feature_detail.domain.VideoStream
import com.codandotv.streamplayerapp.feature_detail.domain.VideoStreamsUseCase
import feature_detail.videoStream
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeVideoStreamsUseCase : VideoStreamsUseCase {
    var getVideoStreamsCalled = false
    var videoStreamsToReturn: List<VideoStream> = listOf(videoStream)

    override suspend fun getVideoStreams(): Flow<List<VideoStream>> {
        getVideoStreamsCalled = true
        return flowOf(videoStreamsToReturn)
    }
}
