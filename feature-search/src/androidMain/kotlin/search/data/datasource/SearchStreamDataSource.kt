package search.data.datasource

import com.codandotv.streamplayerapp.core_networking.handleError.toFlow
import search.data.model.ListSearchStreamResponse
import search.data.api.SearchStreamService
import kotlinx.coroutines.flow.Flow

interface SearchStreamDataSource {
    suspend fun getMovieSearch(query: String): Flow<ListSearchStreamResponse>
}
class SearchStreamDataSourceImpl(
    private val service: SearchStreamService
): SearchStreamDataSource {

    override suspend fun getMovieSearch(query:String): Flow<ListSearchStreamResponse> =
        service.getSearch(query = query).toFlow()
}
