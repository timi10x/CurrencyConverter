package com.example.currencyconverter.models

import com.google.gson.annotations.SerializedName

data class Rates(
    @SerializedName("PLN")
    val pLN: Double? = null
)

/*@SerializedName("USD")
   val uSD: Double? = null,
   @SerializedName("AUD")
   val aUD: Double? = null,
   @SerializedName("CAD")
   val cAD: Double? = null,
   @SerializedName("PLN")
   val pLN: Double? = null,
   @SerializedName("MXN")
   val mNX: Double? = null*/