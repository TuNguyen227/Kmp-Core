package com.nmt.kmpcore.network.builder

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeoutConfig
import io.ktor.http.HttpMessageBuilder
import io.ktor.http.URLProtocol
import kotlinx.serialization.json.Json

interface HttpClientBuilder {
    var baseURL : String
    var baseProtocol : URLProtocol
//    fun protocol(protocol: URLProtocol)
//    fun host(host: String)
    fun build(
        headers: (HttpMessageBuilder.() -> Unit)? = null,
        json: Json? =null,
        httpTimeoutConfig: HttpTimeoutConfig? = null
    ) : HttpClient
}