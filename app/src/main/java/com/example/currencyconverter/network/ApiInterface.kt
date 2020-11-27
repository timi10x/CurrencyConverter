package com.example.currencyconverter.network

import com.example.currencyconverter.models.CurrencyModel
import com.example.currencyconverter.utils.latestValue
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiInterface {
    @GET(latestValue)
    suspend fun getLatest(
        @QueryMap options: Map<String?, Array<String>>?
    ): Response<CurrencyModel>


}