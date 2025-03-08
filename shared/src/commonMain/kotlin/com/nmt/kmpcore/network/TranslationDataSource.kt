package com.nmt.kmpcore.network

import com.nmt.kmpcore.network.model.request.TranslatingText
import com.nmt.kmpcore.network.model.response.TranslateResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.URLProtocol
import io.ktor.http.path

class TranslationDataSource(
    private val client: HttpClient
) : TranslationApi {

    override suspend fun translate(
        request: Array<TranslatingText>,
        source: String,
        target: String
    ): HttpResponse {
        return client.post {
            url {
                path("/translate")
                parameters.append("api-version","3.0")
                parameters.append("fr",source)
                parameters.append("to",target)
                setBody(request)
            }
        }
    }
}