package com.example.currencyconverter.models

import com.google.gson.annotations.SerializedName

data class Rates(
    @SerializedName("PLN")
    val pLN: Double? = null
)