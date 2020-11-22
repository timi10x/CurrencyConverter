package com.example.currencyconverter.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.currencyconverter.models.CurrencyModel

@Dao
interface CurrencyDao {

    //this fetches a live data of the currency
    @Query("SELECT * FROM currencyModel")
    fun getCurrency(): LiveData<CurrencyModel>

    //this saves into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrency(currency: CurrencyModel)

}