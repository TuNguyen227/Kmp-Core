package com.nmt.kmpcore.di

import com.nmt.kmpcore.data.di.provideTranslateRepository
import com.nmt.kmpcore.network.di.provideTranslationHttpClientModule

val coreModule = listOf(
    provideTranslateRepository
)