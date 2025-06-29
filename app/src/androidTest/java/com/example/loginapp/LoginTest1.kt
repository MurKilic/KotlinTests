package com.example.loginapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.loginapp.pages.LoginPage
//import  com.example.tests.Setup
import com.example.tests.Smoke
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.categories.Category
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginTest1 :  Setup() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    //private val loginPage = LoginPage()

/*    @Ignore
    @Test
    @Category(Smoke::class)
    fun testInvalidLogins_DataDriven() {
        val testData = listOf(
            Triple("Koepek", "Koepek", "Login fehlgeschlagen"),
            Triple("", "", "Login fehlgeschlagen"),
            Triple("falsch", "1234", "Login fehlgeschlagen")
        )

        testData.forEach { (username, password, expectedMessage) ->
            loginPage
                .loginWith(username, password)
                .verifyResult(expectedMessage)
        }
    }
    **/

}
