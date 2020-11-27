package com.example.currencyconverter.ui.activity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.currencyconverter.R
import com.example.currencyconverter.databinding.ActivityMainBinding
import com.example.currencyconverter.ui.adapter.CurrencyAdapter
import com.example.currencyconverter.ui.viewModel.MainActivityViewModel
import com.example.currencyconverter.utils.*
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
class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var progressDialog: CustomProgressDialog

    private val viewModel: MainActivityViewModel by viewModels()

    private var flagList: ArrayList<FlagList> =
        ArrayList<FlagList>().apply {
            this.add(eurFlag)
            this.add(cadFlag)
            this.add(plnFlag)
            this.add(usdFlag)
            this.add(mxnFlag)
            this.add(audFlag)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        progressDialog = CustomProgressDialog(this)
        initList()
        spinnerAdapter(flagList)
        setSpinnerListeners()
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
        viewModel.res.observe(this, {
            //checking network state for device
            if (Utils.isOnline(this)) {

                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        progressDialog.hideDialog()
                        //latest_pln_value.text = it.data?.rates?.pLN.toString()

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

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        p1?.let {
            val getCurrency = (p0?.getItemAtPosition(p2) as FlagList).name

            if (p0.id == R.id.from_spinner) {
                viewModel.setFirstCurrencyValue(getCurrency)
                first_currency_value.text = getCurrency
            } else if (p0.id == R.id.to_spinner) {
                viewModel.setSecondCurrencyValue(getCurrency)
                second_currency_value.text = getCurrency
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    private fun spinnerAdapter(arrayFlagList: ArrayList<FlagList>) {
        val currencyAdapter = CurrencyAdapter(this, arrayFlagList)

        from_spinner.adapter = currencyAdapter
        to_spinner.adapter = currencyAdapter

        arrayFlagList.forEachIndexed { index, flagList ->
            if (flagList.name == eurFlag.name)
                from_spinner.setSelection(index)
            if (flagList.name == plnFlag.name)
                to_spinner.setSelection(index)
        }
    }

    private fun initList() {
        flagList = ArrayList()
        flagList.add(eurFlag)
        flagList.add(plnFlag)
        flagList.add(mxnFlag)
        flagList.add(usdFlag)
        flagList.add(audFlag)

    }

    private fun setSpinnerListeners() {
        from_spinner.onItemSelectedListener = this
        to_spinner.onItemSelectedListener = this
    }

}