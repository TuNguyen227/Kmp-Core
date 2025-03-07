package com.nmt.kmpcore.data.di

import com.nmt.kmpcore.data.DefaultTranslateRepository
import com.nmt.kmpcore.data.TranslateRepository
import org.koin.dsl.module

val provideTranslateRepository = module {
    single<TranslateRepository> { DefaultTranslateRepository(get()) }
}