package search.data.repository

import search.data.model.ListSearchStreamResponse
import search.data.datasource.MostPopularMoviesDataSource
import kotlinx.coroutines.flow.Flow

interface MostPopularMoviesRepository {
    suspend fun getMostPopularMovies(): Flow<ListSearchStreamResponse>
}

class MostPopularMoviesRepositoryImpl(
    private val dataSource: MostPopularMoviesDataSource
) : MostPopularMoviesRepository {
    override suspend fun getMostPopularMovies(): Flow<ListSearchStreamResponse> =
        dataSource.getMostPopularMovies()
}
