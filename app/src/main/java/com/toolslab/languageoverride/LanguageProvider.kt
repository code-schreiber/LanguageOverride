package com.toolslab.languageoverride

object LanguageProvider {

    enum class Language(val languageCode: String) {
        Default("en"),
        Other("bez"),
    }

    var currentLanguage = Language.Default
        private set

    fun setCurrentLanguageToDefault() {
        currentLanguage = Language.Default
    }

    fun setCurrentLanguageToOther() {
        currentLanguage = Language.Other
    }
}
