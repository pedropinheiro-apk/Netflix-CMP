package com.codandotv.streamplayerapp.feature_list_streams.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LifecycleOwner
import detail.domain.DetailStreamUseCase
import detail.domain.VideoStreamsUseCase
import detail.presentation.screens.DetailStreamViewModel
import detail.presentation.screens.DetailStreamsUIState
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertTrue

class DetailStreamViewModelTest {
    private lateinit var detailStreamViewModel: detail.presentation.screens.DetailStreamViewModel
    private lateinit var detailUseCase: detail.domain.DetailStreamUseCase
    private lateinit var videoUseCase: detail.domain.VideoStreamsUseCase

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    var executorRule = InstantTaskCoroutinesExecutorRule()

    @Before
    fun setUp() {
        detailUseCase = mockk()
        videoUseCase = mockk()

        detailStreamViewModel = detail.presentation.screens.DetailStreamViewModel(
            detailStreamUseCase = detailUseCase,
            videoStreamsUseCase = videoUseCase,
            dispatcher = executorRule.dispatcher
        )
    }

    @Test
    fun `should load the movies with videoId`() {
        runTest {
            coEvery { detailUseCase.getMovie() } returns flowOf(detailStream)
            coEvery { videoUseCase.getVideoStreams() } returns flowOf(videosStreamsList)

            detailStreamViewModel.loadDetail()

            coVerify {
                detailStreamViewModel.uiState.value.let {
                    detail.presentation.screens.DetailStreamsUIState.LoadingStreamUIState
                }
                detailUseCase.getMovie()
                detailStreamViewModel.uiState.value.let {
                    assertTrue {
                        it == detail.presentation.screens.DetailStreamsUIState.DetailStreamsLoadedUIState(
                            detailStream = detailStream, videoId = videosStreamsList.first().videoId
                        )
                    }
                }
            }
        }
    }

}