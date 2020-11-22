package com.example.currencyconverter.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.currencyconverter.R
import com.example.currencyconverter.databinding.BottomSheetChartBinding
import com.example.currencyconverter.ui.adapter.SparkAdapter
import com.robinhood.spark.SparkView


class GraphChartSheet : RoundedBottomSheetDialog() {

    private var callback: Callback? = null
    fun setCallback(callback: Callback?) {
        this.callback = callback
    }

    private lateinit var binding: BottomSheetChartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetChartBinding.inflate(inflater)
        with(binding) {
            mailText.setOnClickListener {
                dismiss()
            }

            gradientChart.chartValues = arrayOf(
                5f, 25f, 16f, 5f, 8f
            )

            sparkView.adapter = SparkAdapter(floatArrayOf(5f))

        }
        return binding.root
    }


    interface Callback {
        fun onCompleted()
    }

    companion object {
        val instance: GraphChartSheet
            get() = GraphChartSheet()
    }
}