package com.example.currencyconverter.room.repository

import com.example.currencyconverter.newtwork.CurrencyRemoteDataSource
import com.example.currencyconverter.room.dao.CurrencyDao
import com.example.currencyconverter.utils.performGetOperation
import javax.inject.Inject

class CurrencyRepository @Inject constructor(
    private val remoteDataSource: CurrencyRemoteDataSource,
    private val localDataSource: CurrencyDao
) {

    fun getLatest() = performGetOperation(
        databaseQuery = { localDataSource.getCurrency() },
        networkCall = { remoteDataSource.getLatest() },
        saveCallResult = { localDataSource.insertCurrency(it) }
    )
}