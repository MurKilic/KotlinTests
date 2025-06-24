package com.example.loginapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith






@RunWith(AndroidJUnit4::class)
class HauptmenuTest {

    @get:Rule
    val activityRule =ActivityScenarioRule(MainMenuActivity::class.java)

    @Test
    fun checkScreenElements(){
        onView(withId(R.id.mainMenuTitle)).check(matches(withText("Hauptmenü")))
        onView(withId(R.id.radioGroup))

    }

    @Test
    fun testNurLesenRadioButton() {
        onView(withId(R.id.radioNurLesen)).perform(click())
        onView(withId(R.id.editTextBlock))
            .check(matches(isDisplayed()))
            .check(matches(not(isEnabled())))
    }

    @Test
    fun testRadioBtnIsSelected (){
        onView(withId(R.id.radioAktiv)).perform(click())
        onView(withId(R.id.radioAktiv)).check(matches(isChecked()))

        onView(withId(R.id.radioDeaktiv)).check(matches(isNotChecked()))
        onView(withId(R.id.radioNurLesen)).check(matches(isNotChecked()))
    }

    @Test
    fun testCheckAfterClickRadioBtn(){
        onView(withId(R.id.radioAktiv)).perform(click())
        onView(withId(R.id.radioAktiv)).check(matches(isChecked()))
        onView(withId(R.id.radioDeaktiv)).check(matches(isNotChecked()))
        onView(withId(R.id.radioNurLesen)).check(matches(isNotChecked()))

        onView(withId(R.id.radioDeaktiv)).perform(click())
        onView(withId(R.id.radioDeaktiv)).check(matches(isChecked()))
        onView(withId(R.id.radioAktiv)).check(matches(isNotChecked()))
        onView(withId(R.id.radioAktiv)).check(matches(isNotChecked()))

    }

}