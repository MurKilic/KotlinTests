package com.example.loginapp

import android.R.attr.contentDescription
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class LoginTest2 {

    @get:Rule
    val activityrule = ActivityScenarioRule (MainActivity::class.java)

    var usernameField =  onView(withId(R.id.editUsername))
    var passwordField =  onView(withId(R.id.editPassword))
    var mainMenuTitleLabel =  onView(withId(R.id.mainMenuTitle))
    var loginButton = onView(withId(R.id.buttonLogin))
    var textResultLabel = onView(withId(R.id.textResult))

    fun enterloginData(username: String, password: String){

        usernameField.perform(typeText(username))
        passwordField.perform(typeText(password))
    }

    @Test
    fun succcessLogin(){

        usernameField.perform(typeText("admin"))
        passwordField.perform(typeText("admin"))
        loginButton.perform(click())
        mainMenuTitleLabel.check(matches(withText("Hauptmenü")))
    }


    @Test
    fun failedLogin(){
        enterloginData("adminn","admin")
        loginButton.perform(click())
        textResultLabel.check(matches(withText("Login fehlgeschlagen")))
    }



}

//Beispiel: view.contentDescription = "speichernButton"