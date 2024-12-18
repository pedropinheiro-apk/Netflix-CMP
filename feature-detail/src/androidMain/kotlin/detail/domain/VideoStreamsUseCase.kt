package detail.domain

import detail.data.DetailStreamRepository
import kotlinx.coroutines.flow.Flow

interface VideoStreamsUseCase {
    suspend fun getVideoStreams(): Flow<List<VideoStream>>
}

class VideoStreamsUseCaseImpl(
    private val detailStreamRepository: DetailStreamRepository
) : VideoStreamsUseCase {
    override suspend fun getVideoStreams(): Flow<List<VideoStream>> {
        return detailStreamRepository.getVideoStreams()
    }
}