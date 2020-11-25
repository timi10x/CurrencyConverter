package com.example.currencyconverter.ui.activity

import android.content.Context
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
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
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

    inner class CustomMarkerView(context: Context, layoutResource: Int) : MarkerView(
        context, layoutResource
    ) {
        private var mOffset: MPPointF? = null
        override fun getOffset(): MPPointF {
            if (mOffset == null) {
                // center the marker horizontally and vertically
                mOffset = MPPointF(
                    0f,
                    -height.toFloat() + com.github.mikephil.charting.utils.Utils.convertDpToPixel(8f)
                )
            }
            return mOffset!!
        }

        override fun refreshContent(e: Entry?, highlight: Highlight?) {
            /*date.text = dates[e?.x]
            rate.text = "1 ${currencyRates[fromSelectedIndex].currencyCode} = ${e?.y} ${currencyRates[toSelectedIndex].currencyCode}"
            */super.refreshContent(e, highlight)
        }

    }

}