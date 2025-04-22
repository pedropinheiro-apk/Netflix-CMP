package feature_detail.fake

import com.codandotv.streamplayerapp.feature_detail.domain.DetailStream
import com.codandotv.streamplayerapp.feature_detail.domain.DetailStreamUseCase
import feature_detail.fakeStream
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeDetailStreamUseCase : DetailStreamUseCase {
    var getMovieCalled = false
    var lastToggledMovie: DetailStream? = null

    override suspend fun getMovie(): Flow<DetailStream> {
        getMovieCalled = true
        return flowOf(fakeStream)
    }

    override suspend fun toggleItemInFavorites(movie: DetailStream) {
        lastToggledMovie = movie
    }
}
