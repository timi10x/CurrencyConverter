package com.example.currencyconverter.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.currencyconverter.R
import com.example.currencyconverter.databinding.ActivityMainBinding
import com.example.currencyconverter.ui.viewModel.MainActivityViewModel
import com.example.currencyconverter.utils.CustomProgressDialog
import com.example.currencyconverter.utils.Resource
import com.example.currencyconverter.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.bottom_sheet_chart.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var progressDialog: CustomProgressDialog

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        progressDialog = CustomProgressDialog(this)
        with(binding) {
            /*mid_market_view.setOnClickListener {
                //this creates an instance of the bottom frag
                //dialog class to show it
                val graphChartSheet = GraphChartSheet.instance
                graphChartSheet.show(supportFragmentManager, "TAG")
            }*/

            //gives a pre plotted-like view for the chart background
            gradientChart.chartValues = arrayOf(
                5f, 25f, 16f, 5f, 8f
            )

            convert_btn.setOnClickListener {
                setupObservers()
            }
        }


    }

    private fun setupObservers() {
        //observing the livedata call from viewModel
        viewModel.getLatest.observe(this, {
            //checking network state for device
            if (Utils.isOnline(this)) {

                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        progressDialog.hideDialog()

                        //set value from api if successful
                        //to textview
                        latest_pln_value.text = it.data?.rates?.pLN.toString()

                    }
                    Resource.Status.ERROR -> {
                        progressDialog.hideDialog()
                        Toasty.error(this, "error loading", Toasty.LENGTH_SHORT, true)
                            .show()
                    }
                    Resource.Status.LOADING ->
                        progressDialog.showDialog()
                }

            } else {
                Toasty.info(this, "internet is required", Toasty.LENGTH_SHORT, true)
                    .show()
            }
        })
    }

}