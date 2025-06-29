package com.example.loginapp

import android.util.Log
import android.widget.Toast
import androidx.test.platform.app.InstrumentationRegistry
import com.example.loginapp.pages.LoginPage
import org.junit.Before
import org.junit.After

open class Setup {

    private val TAG = "TestSetup"

    @Before
    fun setup() {
        Log.d(TAG, "🔧 Setup läuft")
        val loginPage = LoginPage()



    }

    @After
    fun teardown() {
        Log.d(TAG, "🧹 Teardown läuft")
        // Aufräumen, z. B. DB-Reset, Ressourcen schließen
    }
}