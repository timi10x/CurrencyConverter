package com.example.currencyconvertertest.ui

import androidx.test.core.app.ActivityScenario
import androidx.test.runner.AndroidJUnit4
import com.example.currencyconverter.R
import com.example.currencyconverter.ui.activity.MainActivity
import com.example.currencyconvertertest.screenrobot.MainActivityScreenRobot
import com.gadsphasetwo.screenrobot.ScreenRobot
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Test
    fun mainActivityLaunchesSuccessfully() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun clickSubmitButton() {
        ActivityScenario.launch(MainActivity::class.java)

        ScreenRobot.withRobot(MainActivityScreenRobot::class.java)
            .checkIsDisplayed(R.id.convert_btn)
            .checkIsDisplayed(R.id.toolbar_title)
            .checkIsDisplayed(R.id.tabLayout)
            .clickSubmitButton()
    }
}