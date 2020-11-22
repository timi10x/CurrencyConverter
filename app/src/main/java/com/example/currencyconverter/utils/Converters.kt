package com.example.currencyconverter.utils

import androidx.room.TypeConverter
import com.example.currencyconverter.models.Rates


class Converters {
    @TypeConverter
    fun fromDoubleToRate(value: Double?): Rates? {
        return value?.let { Rates(it) }
    }

    @TypeConverter
    fun fromRatesToDouble(rates: Rates?): Double? {
        return rates?.pLN
    }
}