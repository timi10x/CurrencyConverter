package com.example.currencyconverter.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Rates : Serializable{
    @SerializedName("USD")
    var uSD: Double = Double.MIN_VALUE

    @SerializedName("AUD")
    var aUD: Double = Double.MIN_VALUE

    @SerializedName("CAD")
    var cAD: Double = Double.MIN_VALUE

    @SerializedName("PLN")
    var pLN: Double = Double.MIN_VALUE

    @SerializedName("MXN")
    var mNX: Double = Double.MIN_VALUE
}



