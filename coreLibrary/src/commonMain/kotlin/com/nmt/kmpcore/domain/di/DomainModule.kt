package com.nmt.kmpcore.domain.di

import com.nmt.kmpcore.domain.ChangeLanguageUseCase
import org.koin.dsl.module

val domainModule = module {
    single { ChangeLanguageUseCase(get()) }
}