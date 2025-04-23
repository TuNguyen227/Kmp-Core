package com.nmt.kmpcore.network

import com.nmt.kmpcore.network.model.request.TranslatingText
import com.nmt.kmpcore.network.model.response.TranslateResponse
import io.ktor.client.statement.HttpResponse

interface TranslationApi {
    suspend fun translate(
        request: Array<TranslatingText>,
        source: String,
        target: String
    ) : HttpResponse
}