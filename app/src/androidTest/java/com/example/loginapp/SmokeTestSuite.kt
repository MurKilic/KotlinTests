package com.example.tests

import com.example.loginapp.LoginTest
import com.example.loginapp.LoginTestDataDriven_OneTest
import org.junit.experimental.categories.Categories
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Categories::class)
@Categories.IncludeCategory(Smoke::class)
@Suite.SuiteClasses(
    LoginTestDataDriven_OneTest::class,  // Füge hier alle relevanten Testklassen hinzu
    LoginTest::class
)
class SmokeTestSuite