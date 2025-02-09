package com.codandotv.streamplayerapp.core_networking.handleError

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.client.statement.bodyAsText
import io.ktor.utils.io.errors.IOException
import kotlinx.serialization.SerializationException

suspend inline fun <reified T> HttpClient.safeRequest(
    block: HttpRequestBuilder.() -> Unit,
): NetworkResponse<T> =
    try {
        val response = request { block() }
        NetworkResponse.Success(response.body())
    } catch (exception: ClientRequestException) {
        NetworkResponse.Error(
            body = exception.response.bodyAsText(),
            exception = Failure.ServerError(exception.response.status.value)
        )
    } catch (e: SerializationException) {
        NetworkResponse.Error(
            exception = Failure.UnparsableResponseException(throwable = e)
        )
    } catch (e: IOException) {
        NetworkResponse.Error(
            exception = Failure.NetworkError(throwable = e)
        )
    } catch (e: Exception) {
        NetworkResponse.Error(
            exception = Failure.GenericError(msg = e.message ?: "Unknown error")
        )
    }
