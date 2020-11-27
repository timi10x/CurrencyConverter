package com.example.currencyconverter.ui.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.models.CurrencyModel
import com.example.currencyconverter.room.repository.CurrencyRepository
import com.example.currencyconverter.utils.Resource
import com.example.currencyconverter.utils._firstCurrency
import com.example.currencyconverter.utils._secondCurrency
import kotlinx.coroutines.launch

class MainActivityViewModel @ViewModelInject constructor(
    private val repository: CurrencyRepository
) : ViewModel() {


    private val _res = MutableLiveData<Resource<CurrencyModel>>()

    val res: LiveData<Resource<CurrencyModel>>
        get() = _res

    init {
        getLatest()
    }

    private fun getLatest() = viewModelScope.launch {
        _res.postValue(Resource.loading(null))
        repository.getLatest().let {
            if (it.value?.data?.success!!) {
                _res.postValue(Resource.success(it.value?.data!!))
            } else {
                _res.postValue(Resource.error(it.value?.message!!, null))
            }
        }
    }
    //val getLatest = repository.getLatest()

    fun setFirstCurrencyValue(firstCurrency: String) {
        _firstCurrency.value = firstCurrency
    }

    fun setSecondCurrencyValue(secondCurrency: String) {
        _secondCurrency.value = secondCurrency
    }

}