package com.nmt.kmpcore.provider

import androidx.compose.runtime.mutableStateOf
import kmp_core.corelibrary.generated.resources.Res
import kmp_core.corelibrary.generated.resources.icon_flag_ae
import kmp_core.corelibrary.generated.resources.icon_flag_china
import kmp_core.corelibrary.generated.resources.icon_flag_de
import kmp_core.corelibrary.generated.resources.icon_flag_es
import kmp_core.corelibrary.generated.resources.icon_flag_fr
import kmp_core.corelibrary.generated.resources.icon_flag_in
import kmp_core.corelibrary.generated.resources.icon_flag_it
import kmp_core.corelibrary.generated.resources.icon_flag_jp
import kmp_core.corelibrary.generated.resources.icon_flag_kr
import kmp_core.corelibrary.generated.resources.icon_flag_nl
import kmp_core.corelibrary.generated.resources.icon_flag_pt
import kmp_core.corelibrary.generated.resources.icon_flag_ru
import kmp_core.corelibrary.generated.resources.icon_flag_se
import kmp_core.corelibrary.generated.resources.icon_flag_tr
import kmp_core.corelibrary.generated.resources.icon_flag_us
import org.jetbrains.compose.resources.DrawableResource

object LanguageProvider {
    private val languages by lazy {
        mutableListOf(
            Language.English,
            Language.Spanish,
            Language.Chinese,
            Language.French,
            Language.German,
            Language.Arabic,
            Language.Portuguese,
            Language.Hindi,
            Language.Russian,
            Language.Japanese,
            Language.Korean,
            Language.Italian,
            Language.Turkish,
            Language.Dutch,
            Language.Swedish,
        )
    }

    private val currentLanguage by lazy {
        mutableStateOf<Language?>(null)
    }
    /**
     * Method to get all supported languages.
     *
     * @return list of Languages.
     */
    fun getAllSupportLanguages() : List<Language> {
        return languages
    }

    /**
     * Method to provide more languages.
     *
     * @return nothing.
     */
    fun provideMoreLanguages(list: Array<Language>) {
        languages += list
    }

    /**
     * Method to get current language.
     * If no selected language, then localized language is default.
     *
     * @return [Language].
     */
    fun getLocaleLanguage() : Language {
        return currentLanguage.value ?: languages.find { it.code == LocaleProvider.getRegion() } ?: Language.English
    }

    /**
     * Method to change current language.
     * @param language the target language.
     */
    fun changeCurrentLanguage(language: Language) {
        currentLanguage.value = language
    }
}

sealed class Language(val code: String, val icon: DrawableResource) {
    data object English : Language("us", Res.drawable.icon_flag_us)
    data object Spanish : Language("es", Res.drawable.icon_flag_es)
    data object Chinese : Language("cn", Res.drawable.icon_flag_china)
    data object French : Language("fr", Res.drawable.icon_flag_fr)
    data object German : Language("de", Res.drawable.icon_flag_de)
    data object Arabic : Language("ae", Res.drawable.icon_flag_ae)
    data object Portuguese : Language("pt", Res.drawable.icon_flag_pt)
    data object Hindi : Language("in", Res.drawable.icon_flag_in)
    data object Russian : Language("ru", Res.drawable.icon_flag_ru)
    data object Japanese : Language("jp", Res.drawable.icon_flag_jp)
    data object Korean : Language("kr", Res.drawable.icon_flag_kr)
    data object Italian : Language("it", Res.drawable.icon_flag_it)
    data object Turkish : Language("tr", Res.drawable.icon_flag_tr)
    data object Dutch : Language("nl", Res.drawable.icon_flag_nl)
    data object Swedish : Language("se", Res.drawable.icon_flag_se)
}
