package com.example.currencyconverter.ui.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.currencyconverter.room.repository.CurrencyRepository

class MainActivityViewModel @ViewModelInject constructor(
    private val repository: CurrencyRepository
) : ViewModel() {

    val getLatest = repository.getLatest()

}