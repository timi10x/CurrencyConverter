package com.example.currencyconverter.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "historicalModel")
data class HistoricalModel(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("timestamp")
    val timestamp: Int,

    @SerializedName("historical")
    val historical: String,

    @SerializedName("base")
    val base: String,

    @SerializedName("date")
    val date: String,

    @SerializedName("rates")
    val rates: Rates
) {
    @PrimaryKey(autoGenerate = true)
    var historicalId: Int = 0
}