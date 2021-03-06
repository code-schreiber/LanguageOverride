package com.toolslab.languageoverride

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.toolslab.languageoverride.LanguageProvider.Language.Other
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OtherLanguageTest {

    lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        LanguageProvider.setCurrentLanguageToOther()

        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()

        LanguageProvider.setCurrentLanguageToDefault()
    }

    @Test
    fun resources_language_is_other_language() {
        val textView = onView(withId(R.id.resourcesLanguageTextView))

        textView.check(matches(withText(Other.languageCode)))
    }

    @Test
    fun current_language_is_other_language() {
        val textView = onView(withId(R.id.currentLanguageTextView))

        textView.check(matches(withText(Other.languageCode)))
    }

    @Test
    fun actual_language_is_other_language() {
        val textView = onView(withId(R.id.actualLanguageTextView))

        textView.check(matches(withText(Other.languageCode)))
    }
}
