package com.nmt.kmpcore.network

import com.nmt.kmpcore.network.model.ResultWrapper
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode

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
    }
}