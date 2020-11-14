package com.toolslab.languageoverride

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.toolslab.languageoverride.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun attachBaseContext(context: Context) {
        val newLanguage = LanguageProvider.currentLanguage.languageCode
        val newContext = LocaleChanger.changeLocale(context, newLanguage)
        super.attachBaseContext(newContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews(binding)
    }

    private fun initViews(binding: ActivityMainBinding) {
        with(binding) {
            val currentLanguage = LanguageProvider.currentLanguage
            val isLanguageDefault = currentLanguage == LanguageProvider.Language.Default

            title = resources.getString(R.string.app_name)
            resourcesLanguageTextView.text = resources.configuration.locale.language
            currentLanguageTextView.text = resources.getString(R.string.actual_language)
            actualLanguageTextView.text = currentLanguage.languageCode
            toggleButton.isChecked = isLanguageDefault

            toggleButton.setOnCheckedChangeListener { button, isChecked ->
                if (isChecked) {
                    LanguageProvider.setCurrentLanguageToDefault()
                } else {
                    LanguageProvider.setCurrentLanguageToOther()
                }
                button.context.startActivity(Intent(button.context, MainActivity::class.java))
            }
        }
    }
}
