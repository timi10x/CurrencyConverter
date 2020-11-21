package com.example.currencyconverter.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.currencyconverter.databinding.BottomSheetChartBinding

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