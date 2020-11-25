package com.example.currencyconverter.utils

import androidx.lifecycle.MutableLiveData

const val API_KEY = "4ab40806f4d7df628cf6cbc5d6780324"
const val symbol = "PLN"
const val DB_NAME = "currencyConverter"
const val BASE_URL = "http://data.fixer.io/api/"
const val value = "latest?access_key=${API_KEY}&symbols=$symbol"

val _firstCurrency = MutableLiveData<String>()
val _secondCurrency = MutableLiveData<String>()

var eurFlag = FlagList("EUR")
var cadFlag = FlagList("CAD")
var plnFlag = FlagList("PLN")
var usdFlag = FlagList("USD")
var mxnFlag = FlagList("MXN")
var audFlag = FlagList("AUD")





