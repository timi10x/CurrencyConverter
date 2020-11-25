package com.example.currencyconverter.ui.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyconverter.room.repository.CurrencyRepository
import com.example.currencyconverter.utils._firstCurrency
import com.example.currencyconverter.utils._secondCurrency

class MainActivityViewModel @ViewModelInject constructor(
    private val repository: CurrencyRepository
) : ViewModel() {


    val getLatest = repository.getLatest()

    fun setFirstCurrencyValue(firstCurrency: String) {
        _firstCurrency.value = firstCurrency
    }

    fun setSecondCurrencyValue(secondCurrency: String) {
        _secondCurrency.value = secondCurrency
    }
}