package com.example.currencyconvertertest.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.example.currencyconverter.models.CurrencyModel
import com.example.currencyconverter.models.Rates
import com.example.currencyconverter.room.dao.CurrencyDao
import com.example.currencyconverter.room.database.AppDatabase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CurrencyDaoTest {
    private lateinit var database: AppDatabase

    private lateinit var currencyDao: CurrencyDao

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val currencyA = CurrencyModel(
        true,
        1519296206,
        "EUR",
        "2020-11-22",
        Rates(4.3)
    )

    @Before
    fun createDb() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        currencyDao = database.currencyDao()

    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeCurrencyAndReadInList() = runBlocking{
        currencyDao.insertCurrency(currencyA)
    }
}