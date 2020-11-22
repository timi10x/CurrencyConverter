package com.example.currencyconvertertest.screenrobot

import com.example.currencyconverter.R
import com.gadsphasetwo.screenrobot.ScreenRobot


class MainActivityScreenRobot : ScreenRobot<MainActivityScreenRobot>() {

    fun clickSubmitButton(): MainActivityScreenRobot {
        return clickOkOnView(R.id.convert_btn)
    }

}