package com.example.loginapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

@RunWith(AndroidJUnit4::class)
@LargeTest
class EspressoTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun changeText_sameActivity() {

        //Eingabe im Textfeld für Benutzername
        onView(withId(R.id.editUsername)).perform(typeText("Kotlin"), closeSoftKeyboard())

        // Klick auf den Login- Button
        onView(withId(R.id.buttonLogin)).perform(click())

        // Überprüfung des Ergebnisses
        onView(withId(R.id.textResult)).check(matches(withText("Login erfolgreich"))) // oder was auch immer erscheint
    }
}