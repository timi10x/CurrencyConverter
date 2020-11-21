package com.example.currencyconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.currencyconverter.databinding.ActivityMainBinding
import com.example.currencyconverter.utils.GraphChartSheet
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.content_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        with(binding) {
            mid_market_view.setOnClickListener {
                val graphChartSheet = GraphChartSheet.instance
                graphChartSheet.show(supportFragmentManager, "TAG")
            }
        }
    }
}