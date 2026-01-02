package com.nmt.kmpcore.domain

import com.nmt.kmpcore.data.TranslateRepository

class ChangeLanguageUseCase(
    private val translateRepository: TranslateRepository
) {
    suspend operator fun invoke(
        strings: Array<String>,
        from: String,
        to: String
    ) : List<String>? {
        val result = translateRepository.translate(
            strings = strings,
            source = from,
            target = to
        )
        return result
    }
}