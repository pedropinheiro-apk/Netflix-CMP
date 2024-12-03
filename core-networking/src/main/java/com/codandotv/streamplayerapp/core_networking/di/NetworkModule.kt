package com.codandotv.streamplayerapp.core_networking.di

import android.util.Log
import com.codandotv.streamplayerapp.core.networking.BuildConfig
import com.codandotv.streamplayerapp.core_networking.handleError.validator
import com.squareup.moshi.Moshi
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import org.koin.dsl.module

object NetworkModule {
    val module = module {
        single(QualifierHost) { BuildConfig.HOST }
        single(QualifierProfile) { BuildConfig.PROFILE }

//        single(QualifierAuthInterceptor) {
//            Interceptor { chain ->
//                val newRequest = chain.request()
//                    .newBuilder()
//                    .addHeader("Authorization", BuildConfig.API_BEARER_AUTH)
//                    .addHeader("Content-Type", "application/json;charset=utf-8")
//                    .build()
//                chain.proceed(newRequest)
//            }
//        }

        single {
            provideKtorHttpClient(
                moshi = get(),
                baseUrl = get(QualifierHost),
            )
        }

        single(QualifierProfileHttpClient) {
            provideKtorHttpClient(
                moshi = get(),
                baseUrl = get(QualifierProfile),
            )
        }

        single { Moshi.Builder().build() }
    }

    private fun provideKtorHttpClient(
        moshi: Moshi,
        baseUrl: String,
    ): HttpClient {
        return HttpClient(OkHttp) {
            installPlugins(moshi, baseUrl)
        }
    }

    private fun HttpClientConfig<OkHttpConfig>.installPlugins(
        moshi: Moshi,
        baseUrl: String,
    ) {
        expectSuccess = false

        install(ContentNegotiation) {
            json(Json {
                explicitNulls = false
                ignoreUnknownKeys = true
            })
        }

        install(HttpTimeout) {
            socketTimeoutMillis = 10000
            requestTimeoutMillis = 10000
            connectTimeoutMillis = 10000
        }

        defaultRequest {
            url(baseUrl)
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }

        validator(moshi)

        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(
                        accessToken = BuildConfig.API_BEARER_AUTH,
                        refreshToken = ""
                    )
                }
            }
        }

        if (BuildConfig.DEBUG) {
            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.i("HttpClient", message)
                    }
                }
            }
        }
    }
}