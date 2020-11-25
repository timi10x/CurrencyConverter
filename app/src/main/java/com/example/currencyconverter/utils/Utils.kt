package com.example.currencyconverter.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class Utils {
    companion object {
        fun isOnline(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            return activeNetwork?.isConnectedOrConnecting == true
        }

        private fun formatValue(value: String): String {
            var resValue = value
            if (value[value.length - 1] == '.' && value.indexOfFirst { it == '.' } != value.length - 1) {
                resValue = value.dropLast(1)
            }
            val res = NumberFormat.getNumberInstance(Locale.getDefault())
                .format(
                    BigDecimal.valueOf(resValue.replace(",", "").toDouble())
                        .setScale(2, BigDecimal.ROUND_HALF_UP)
                )
            return if (resValue[resValue.length - 1] == '.') "$res." else res
        }
    }
}