package search.di

import search.data.api.SearchStreamService
import search.data.datasource.SearchStreamDataSourceImpl
import search.data.datasource.MostPopularMoviesDataSource
import search.data.datasource.MostPopularMoviesDataSourceImpl
import search.data.repository.MostPopularMoviesRepository
import search.data.repository.MostPopularMoviesRepositoryImpl
import search.data.api.MostPopularMoviesService
import search.data.api.MostPopularMoviesServiceImpl
import search.data.api.SearchStreamServiceImpl
import search.data.datasource.SearchStreamDataSource
import search.data.repository.SearchStreamRepository
import search.data.repository.SearchStreamRepositoryImp
import search.domain.MostPopularMoviesUseCase
import search.domain.MostPopularMoviesUseCaseImpl
import search.domain.SearchUseCase
import search.domain.SearchUseCaseImpl
import search.presentation.screens.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object SearchModule {
    val module = module {
        viewModel {
            SearchViewModel(
                searchUseCase = get(),
                mostPopularMoviesUseCase = get()
            )
        }

        factory<SearchStreamService> { SearchStreamServiceImpl(get()) }
        factory<MostPopularMoviesService> { MostPopularMoviesServiceImpl(get()) }

        factory<MostPopularMoviesUseCase> { MostPopularMoviesUseCaseImpl(repository = get()) }
        factory<MostPopularMoviesDataSource> { MostPopularMoviesDataSourceImpl(service = get()) }
        factory<MostPopularMoviesRepository> { MostPopularMoviesRepositoryImpl(dataSource = get()) }

        factory<SearchUseCase> { SearchUseCaseImpl(repository = get()) }
        factory<SearchStreamDataSource> { SearchStreamDataSourceImpl(service = get()) }
        factory<SearchStreamRepository> { SearchStreamRepositoryImp(dataSource = get()) }
    }
}
