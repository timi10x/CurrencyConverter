package com.example.currencyconverter.network

class CurrencyRemoteDataSource(private val apiInterface: ApiInterface) : BaseDataSource() {

    private val symbol = arrayOf(
        "EUR",
        "CAD",
        "PLN",
        "USD",
        "MXN",
        "AUD"
    )

    suspend fun getLatest() = getResult {
        val data: MutableMap<String?, Array<String>>? = HashMap()
        data?.set("symbols", symbol)
        apiInterface.getLatest(data)
    }


}