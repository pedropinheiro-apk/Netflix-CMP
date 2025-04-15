package feature_detail

import com.codandotv.streamplayerapp.feature_detail.presentation.screens.DetailStreamViewModel
import feature_detail.fake.FakeDetailStreamUseCase
import feature_detail.fake.FakeVideoStreamsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class DetailStreamViewModelTest {

    private lateinit var detailStreamViewModel: DetailStreamViewModel
    private lateinit var detailUseCase: FakeDetailStreamUseCase
    private lateinit var videoUseCase: FakeVideoStreamsUseCase

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        detailUseCase = FakeDetailStreamUseCase()
        videoUseCase = FakeVideoStreamsUseCase()

        detailStreamViewModel = DetailStreamViewModel(
            detailStreamUseCase = detailUseCase,
            videoStreamsUseCase = videoUseCase,
            dispatcher =  StandardTestDispatcher()
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `should load the movies with videoId`() = runTest {
        detailStreamViewModel.loadDetail()

        advanceUntilIdle()
        assertEquals(expectedDetailStreamLoadedUI, detailStreamViewModel.uiState.value)
        assertEquals(true, detailUseCase.getMovieCalled)
        assertEquals(true, videoUseCase.getVideoStreamsCalled)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @AfterTest
    fun after() {
        Dispatchers.resetMain()
    }
}
