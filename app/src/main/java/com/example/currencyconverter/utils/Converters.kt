package com.example.currencyconverter.utils

import androidx.room.TypeConverter
import com.example.currencyconverter.models.CurrencyModel
import com.example.currencyconverter.models.Rates
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {
    @TypeConverter
    fun fromStringToRates(value: String): Rates {
        val type = object : TypeToken<Rates>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromRatesToString(currencyModel: Rates): String {
        val type = object : TypeToken<Rates>() {}.type
        return Gson().toJson(currencyModel, type)
    }
}