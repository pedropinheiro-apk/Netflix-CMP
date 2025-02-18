package com.codandotv.streamplayerapp.core_networking.di

import com.codandotv.streamplayerapp.core_networking.di.Network.TIMEOUT
import com.codandotv.streamplayerapp.core_networking.httpClientEnginePlatform
import core.networking.BuildKonfig
import io.ktor.client.HttpClient
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
import kotlinx.serialization.json.Json
import org.koin.dsl.module

object NetworkModule {
    val module = module {
        single(QualifierHost) { BuildKonfig.HOST }
        single(QualifierProfile) { BuildKonfig.PROFILE }

        single {
            provideKtorHttpClient(
                baseUrl = get(QualifierHost),
            )
        }

        single(QualifierProfileHttpClient) {
            provideKtorHttpClient(
                baseUrl = get(QualifierProfile),
            )
        }
    }

    private fun provideKtorHttpClient(
        baseUrl: String,
    ): HttpClient {
        return HttpClient(engine = httpClientEnginePlatform()) {
            expectSuccess = false

            install(ContentNegotiation) {
                json(Json {
                    explicitNulls = false
                    ignoreUnknownKeys = true
                })
            }

            install(HttpTimeout) {
                socketTimeoutMillis = TIMEOUT
                requestTimeoutMillis = TIMEOUT
                connectTimeoutMillis = TIMEOUT
            }

            defaultRequest {
                url(baseUrl)
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }

            install(Auth) {
                bearer {
                    loadTokens {
                        BearerTokens(
                            accessToken = BuildKonfig.API_BEARER_AUTH,
                            refreshToken = ""
                        )
                    }
                }
            }

            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        //TODO: Migrar Logs para Utilizar Kermit
                        println("HttpClient${message}")
                    }
                }
            }
        }
    }
}

internal object Network {
    const val TIMEOUT = 10000L
}