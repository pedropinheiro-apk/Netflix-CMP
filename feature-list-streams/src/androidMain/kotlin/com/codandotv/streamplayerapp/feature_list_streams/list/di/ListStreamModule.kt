package com.codandotv.streamplayerapp.feature_list_streams.list.di

import com.codandotv.streamplayerapp.feature_list_streams.list.data.ListStreamService
import com.codandotv.streamplayerapp.feature_list_streams.list.data.ListStreamServiceImpl
import io.ktor.client.HttpClient
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.context.GlobalContext

@Module
@ComponentScan("com.codandotv.streamplayerapp.feature_list_streams.list")
class ListStreamModule {

    @Factory
    fun service(): ListStreamService {
        val koin = GlobalContext.get()
        val httpClient = koin.get<HttpClient>()
        return ListStreamServiceImpl(httpClient)
    }
}