package com.nmt.kmpcore.network.builder

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.EndpointConfig
import io.ktor.http.HttpMessageBuilder
import io.ktor.http.URLProtocol
import kotlinx.serialization.json.JsonConfiguration

interface HttpClientBuilder {
    var baseURL : String
    var baseProtocol : URLProtocol
//    fun protocol(protocol: URLProtocol)
//    fun host(host: String)
    fun build(
        endPointConfig: EndpointConfig? = null,
        headers: (HttpMessageBuilder.() -> Unit)? = null,
        jsonConfiguration: JsonConfiguration? = null,
    ) : HttpClient
}