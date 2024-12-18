package search.domain

import search.data.model.ListSearchStreamResponse
import search.data.repository.SearchStreamRepository
import kotlinx.coroutines.flow.Flow

interface SearchUseCase {
    suspend operator fun invoke(query:String): Flow<ListSearchStreamResponse>
}

class SearchUseCaseImpl(val repository: SearchStreamRepository) : SearchUseCase {
    override suspend operator fun invoke(query:String): Flow<ListSearchStreamResponse> {
        return repository.getMovieSearch(query = query)
    }
}
