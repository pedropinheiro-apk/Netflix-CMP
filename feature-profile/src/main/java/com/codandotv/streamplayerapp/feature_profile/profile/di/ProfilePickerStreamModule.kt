package com.codandotv.streamplayerapp.feature_profile.profile.di

import com.codandotv.streamplayerapp.core_networking.di.QualifierProfileHttpClient
import com.codandotv.streamplayerapp.feature_profile.profile.data.ProfilePickerStreamService
import com.codandotv.streamplayerapp.feature_profile.profile.data.ProfilePickerStreamServiceImpl
import io.ktor.client.HttpClient
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.context.GlobalContext

@Module
@ComponentScan("com.codandotv.streamplayerapp.feature_profile")
class ProfilePickerStreamModule {

    @Factory
    fun service(): ProfilePickerStreamService {
        val koin = GlobalContext.get()
        val httpClient = koin.get<HttpClient>(QualifierProfileHttpClient)
        return ProfilePickerStreamServiceImpl(httpClient)
    }

}
