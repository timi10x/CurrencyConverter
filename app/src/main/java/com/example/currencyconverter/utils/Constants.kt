package com.example.currencyconverter.utils

import androidx.lifecycle.MutableLiveData

const val API_KEY = "4ab40806f4d7df628cf6cbc5d6780324"
val symbol = arrayOf(
    "EUR",
    "CAD",
    "PLN",
    "USD",
    "MXN",
    "AUD"
)
const val DB_NAME = "currencyConverter"
const val BASE_URL = "http://data.fixer.io/api/"

//const val latestValue = "latest?access_key=${API_KEY}&symbols=$symbol"
const val latestValue = "latest?access_key=${API_KEY}"

val historicalValue = "YYYY-MM-DD?access_key=${API_KEY}&symbols=$symbol"

val _firstCurrency = MutableLiveData<String>()
val _secondCurrency = MutableLiveData<String>()

var eurFlag = FlagList("EUR")
var cadFlag = FlagList("CAD")
var plnFlag = FlagList("PLN")
var usdFlag = FlagList("USD")
var mxnFlag = FlagList("MXN")
var audFlag = FlagList("AUD")





