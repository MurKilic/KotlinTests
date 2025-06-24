package com.example.loginapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Ignore("aktuell kein bestandteil")
    @Test
    fun testValidLoginShowsSuccessMessage() {
        onView(withId(R.id.editUsername)).perform(typeText("admin"), closeSoftKeyboard())
        onView(withId(R.id.editPassword)).perform(typeText("admin"), closeSoftKeyboard())
        onView(withId(R.id.buttonLogin)).perform(click())
        onView(withId(R.id.textResult)).check(matches(withText("Login erfolgreich")))
    }

    @Test
    fun TestInvalidErrorMessage(){
        onView(withId(R.id.editUsername)).perform(typeText("Koepek"), closeSoftKeyboard())
        onView(withId(R.id.editPassword)).perform(typeText("Koepek"), closeSoftKeyboard())
        onView(withId(R.id.buttonLogin)).perform(click())

       onView(withId(R.id.textResult)).check(matches(withText("Login fehlgeschlagen")))
    }

    @Test
    fun loginNavigatesToMainMenu() {
        onView(withId(R.id.editUsername)).perform(typeText("admin"), closeSoftKeyboard())
        onView(withId(R.id.editPassword)).perform(typeText("admin"), closeSoftKeyboard())
        onView(withId(R.id.buttonLogin)).perform(click())
        onView(withId(R.id.mainMenuTitle)).check(matches(withText("Hauptmenü")))
    //Test Commit 2
    }

    @Test
    fun screenCheckElements(){
        onView(withId(R.id.editUsername)).check(matches(withHint("Benutzername")))
        onView(withId(R.id.editPassword)).check(matches(withHint("Passwort")))
        onView(withId(R.id.buttonLogin)).check(matches(withText("Login")))
    }



}
