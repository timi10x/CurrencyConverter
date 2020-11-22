package com.example.currencyconverter.newtwork

class CurrencyRemoteDataSource(private val apiInterface: ApiInterface) : BaseDataSource() {

    suspend fun getLatest() = getResult {
        apiInterface.getLatest()
    }
}