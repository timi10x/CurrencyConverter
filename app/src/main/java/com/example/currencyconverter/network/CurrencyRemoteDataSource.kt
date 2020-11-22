package com.example.currencyconverter.network

class CurrencyRemoteDataSource(private val apiInterface: ApiInterface) : BaseDataSource() {

    suspend fun getLatest() = getResult {
        apiInterface.getLatest()
    }
}