package com.codandotv.streamplayerapp.feature_list_streams.detail

import detail.data.DetailStreamRepository
import detail.domain.DetailStream
import detail.domain.DetailStreamUseCase
import detail.domain.DetailStreamUseCaseImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertTrue

class DetailStreamUseCaseTest {
    private lateinit var detailStreamUseCase: detail.domain.DetailStreamUseCase
    private lateinit var detailStreamRepository: detail.data.DetailStreamRepository

    @Before
    fun setUp() {
        detailStreamRepository = mockk()
        detailStreamUseCase = detail.domain.DetailStreamUseCaseImpl(
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