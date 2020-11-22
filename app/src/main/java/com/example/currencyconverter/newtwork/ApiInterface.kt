package com.example.currencyconverter.newtwork

import com.example.currencyconverter.models.CurrencyModel
import com.example.currencyconverter.utils.value
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET(value)
    suspend fun getLatest(): Response<CurrencyModel>
}