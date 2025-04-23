package com.nmt.kmpcore.data

import com.nmt.kmpcore.network.TranslationApi
import com.nmt.kmpcore.network.TranslationDataSource
import com.nmt.kmpcore.network.model.ResultWrapper
import com.nmt.kmpcore.network.model.request.TranslatingText
import com.nmt.kmpcore.network.model.response.TranslateResponse
import com.nmt.kmpcore.network.safeApiCall

class DefaultTranslateRepository(
    private val translationApi: TranslationApi
) : TranslateRepository {
    override suspend fun translate(strings: Array<String>, source: String, target: String) : List<String>? {
        val result = safeApiCall<List<TranslateResponse>> {
            translationApi.translate(
                request = strings.map {
                    TranslatingText(it)
                }.toTypedArray(),
                source = source,
                target = target
            )
        }
        return when(result) {
            is ResultWrapper.Success -> {
                result.data.map { (it as? TranslateResponse.TranslateSuccess)?.translatedText ?: "" }
            }
            is ResultWrapper.Error -> {
                null
            }
        }
    }
}