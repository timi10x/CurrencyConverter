package com.example.currencyconverter.utils

import com.example.currencyconverter.R

class FlagList(val name: String, var flagImage: Int = R.drawable.eur) {
    init {
        flagImage = MappedFalg[name] ?: R.drawable.eur
    }
}

object MappedFalg : HashMap<String, Int>(HashMap<String, Int>().apply {
    put("CAD", R.drawable.cad)
    put("EUR", R.drawable.eur)
    put("MXN", R.drawable.mxn)
    put("PLN", R.drawable.pln)
    put("USD", R.drawable.usd)
    put("AUD", R.drawable.aud)
})