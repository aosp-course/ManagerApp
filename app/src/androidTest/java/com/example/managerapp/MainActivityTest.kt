package com.example.managerapp

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    private lateinit var appList: MutableList<AppInfo>

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        appList = mutableListOf()
    }
    @Test
    fun verifyActivityNotNull() {
        // 1. Launch the Activity using ActivityScenario
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // 2. Use scenario.onActivity to access the Activity instance
        scenario.onActivity { activity ->
            assertNotNull(activity)
        }
    }
    @Test
    fun activityNotNull() {
        // 1. Launch the Activity using ActivityScenario
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // 2. Use scenario.onActivity to access the Activity instance
        scenario.onActivity { activity ->
            activity.loadInstalledApps()
            assertTrue(activity.appList.isNotEmpty())
        }
    }

    @Test
    fun testRecyclerViewIsDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)
        // Teste usando Espresso que verifica se a RecyclerView aparece na tela
        onView(withId(R.id.recyclerViewApps)).check(matches(isDisplayed()))
    }
}