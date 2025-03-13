package com.nmt.kmpcore.data

import com.nmt.kmpcore.network.TranslationDataSource
import com.nmt.kmpcore.network.model.ResultWrapper
import com.nmt.kmpcore.network.model.request.TranslatingText
import com.nmt.kmpcore.network.model.response.TranslateResponse
import com.nmt.kmpcore.network.safeApiCall

internal class DefaultTranslateRepository(
    private val translationDataSource: TranslationDataSource
) : TranslateRepository {
    override suspend fun translate(strings: Array<String>, source: String, target: String) : String? {
        val result = safeApiCall<TranslateResponse> {
            translationDataSource.translate(
                request = strings.map {
                    TranslatingText(it)
                }.toTypedArray(),
                source = source,
                target = target
            )
        }
        return when(result) {
            is ResultWrapper.Success -> {
                (result.data as? TranslateResponse.TranslateSuccess)?.translatedText ?: ""
            }
            is ResultWrapper.Error -> {
                null
            }
        }
    }
}