package search.data.datasource

import com.codandotv.streamplayerapp.core_networking.handleError.toFlow
import search.data.model.ListSearchStreamResponse
import search.data.api.MostPopularMoviesService
import kotlinx.coroutines.flow.Flow

interface MostPopularMoviesDataSource {
    suspend fun getMostPopularMovies(): Flow<ListSearchStreamResponse>
}

class MostPopularMoviesDataSourceImpl(
    private val service: MostPopularMoviesService
) : MostPopularMoviesDataSource {

    override suspend fun getMostPopularMovies(): Flow<ListSearchStreamResponse> =
        service.getPopular().toFlow()
}
