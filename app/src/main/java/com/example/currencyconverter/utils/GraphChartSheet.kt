package com.example.currencyconverter.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.currencyconverter.databinding.BottomSheetChartBinding


class GraphChartSheet : RoundedBottomSheetDialog() {

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

            //gives a pre plotted-like view for the chart background
            gradientChart.chartValues = arrayOf(
                5f, 25f, 16f, 5f, 8f
            )

        }
        return binding.root
    }

    companion object {
        val instance: GraphChartSheet
            get() = GraphChartSheet()
    }

}