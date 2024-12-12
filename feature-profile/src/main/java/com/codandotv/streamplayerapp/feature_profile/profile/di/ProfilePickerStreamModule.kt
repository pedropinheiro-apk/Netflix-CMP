package com.codandotv.streamplayerapp.feature_profile.profile.di

import com.codandotv.streamplayerapp.feature_profile.profile.data.ProfilePickerStreamRepository
import com.codandotv.streamplayerapp.feature_profile.profile.data.ProfilePickerStreamRepositoryImpl
import com.codandotv.streamplayerapp.feature_profile.profile.data.ProfilePickerStreamService
import com.codandotv.streamplayerapp.feature_profile.profile.data.ProfilePickerStreamServiceImpl
import com.codandotv.streamplayerapp.feature_profile.profile.domain.ProfilePickerStreamUseCase
import com.codandotv.streamplayerapp.feature_profile.profile.domain.ProfilePickerStreamUseCaseImpl
import com.codandotv.streamplayerapp.feature_profile.profile.presentation.screens.ProfilePickerStreamViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ProfilePickerStreamModule {
    val module = module {
        viewModel {
            ProfilePickerStreamViewModel(
                useCase = get()
            )
        }

        factory<ProfilePickerStreamUseCase> {
            ProfilePickerStreamUseCaseImpl(
                profilePickerStreamRepository = get()
            )
        }

        factory<ProfilePickerStreamRepository> {
            ProfilePickerStreamRepositoryImpl(
                service = get()
            )
        }

        factory<ProfilePickerStreamService> {
            ProfilePickerStreamServiceImpl(
                client = get()
            )
        }
    }
}