package com.example.currencyconverter.ui.adapter

import com.robinhood.spark.SparkAdapter

class SparkAdapter(private val yData: FloatArray) : SparkAdapter() {

    //this is the adapter for the spark graph
    override fun getCount(): Int {
        return yData.size
    }

    override fun getItem(index: Int): Any {
        return yData[index]
    }

    override fun getY(index: Int): Float {
        return yData[index]
    }
}