package com.nmt.kmpcore.network

import com.nmt.kmpcore.network.model.ResultWrapper
import io.ktor.client.call.body
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import kotlinx.io.IOException

suspend inline fun <reified T> safeApiCall(
    crossinline apiCall: suspend () -> HttpResponse
): ResultWrapper<T> {
    return try {
        val response = apiCall.invoke()
        when(response.status) {
            HttpStatusCode.OK -> {
                ResultWrapper.Success(data = response.body())
            }
            else -> ResultWrapper.Error(
                message = "Unknown error: ${response.status}",
                code = response.status.value
            )
        }

    } catch (e: Exception) {
        ResultWrapper.Error(
            message = "${e.message}",
            code = 500
        )
    } catch (e: ServerResponseException) {
        ResultWrapper.Error(
            message = e.message.ifEmpty { "Internal Server Error" },
            code = e.response.status.value
        )
    } catch (e: IOException) {
        ResultWrapper.Error(
            message = e.message ?: "Internal Server Error",
            code = 500
        )
    }
}