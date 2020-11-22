package com.example.currencyconverter.utils

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.currencyconverter.databinding.BottomSheetChartBinding
import com.example.currencyconverter.ui.adapter.SparkAdapter
import com.robinhood.spark.SparkView.OnScrubListener


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
            /*sparkView.scrubListener = OnScrubListener { value ->
                scrubInfoTextView.setText(
                    getString(
                        R.string.scrub_format,
                        value
                    )
                )
            }*/
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