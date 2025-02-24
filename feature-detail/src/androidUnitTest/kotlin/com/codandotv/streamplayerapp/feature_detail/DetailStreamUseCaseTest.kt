package com.codandotv.streamplayerapp.feature_detail

import com.codandotv.streamplayerapp.feature_detail.data.DetailStreamRepository
import com.codandotv.streamplayerapp.feature_detail.domain.DetailStreamUseCase
import com.codandotv.streamplayerapp.feature_detail.domain.DetailStreamUseCaseImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertTrue

class DetailStreamUseCaseTest {
    private lateinit var detailStreamUseCase: DetailStreamUseCase
    private lateinit var detailStreamRepository: DetailStreamRepository

    @Before
    fun setUp() {
        detailStreamRepository = mockk()
        detailStreamUseCase = DetailStreamUseCaseImpl(
            detailStreamRepository = detailStreamRepository
        )
    }

    @Test
    fun `load movies`() {
        runTest {
            coEvery { detailStreamRepository.getMovie() } returns flowOf(detailStream)

            detailStreamUseCase.getMovie()
                .collect{
                    assertTrue {
                        it == detailStream
                    }
                }

            coVerify{
                detailStreamRepository.getMovie()
            }
        }
    }
}