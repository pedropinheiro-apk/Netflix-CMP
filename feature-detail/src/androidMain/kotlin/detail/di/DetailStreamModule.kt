package detail.di

import detail.data.DetailStreamRepository
import detail.data.DetailStreamRepositoryImpl
import detail.data.DetailStreamService
import detail.data.DetailStreamServiceImpl
import detail.domain.DetailStreamUseCase
import detail.domain.DetailStreamUseCaseImpl
import detail.domain.VideoStreamsUseCase
import detail.domain.VideoStreamsUseCaseImpl
import detail.presentation.screens.DetailStreamViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

object DetailStreamModule {
    val module = module {
        viewModel { (id: String) ->
            DetailStreamViewModel(
                detailStreamUseCase = get {
                    parametersOf(id)
                },
                videoStreamsUseCase = get {
                    parametersOf(id)
                },
                dispatcher = Dispatchers.IO
            )
        }
        factory<DetailStreamUseCase> { (id: String) ->
            DetailStreamUseCaseImpl(
                detailStreamRepository = get {
                    parametersOf(id)
                }
            )
        }
        factory<VideoStreamsUseCase> { (id: String) ->
            VideoStreamsUseCaseImpl(
                detailStreamRepository = get {
                    parametersOf(id)
                }
            )
        }
        factory<DetailStreamRepository> { (id: String) ->
            DetailStreamRepositoryImpl(
                favoriteDao = get(),
                service = get(),
                movieId = id,
            )
        }

        factory<DetailStreamService> {
            DetailStreamServiceImpl(
                client = get()
            )
        }
    }
}