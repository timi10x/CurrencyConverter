package com.example.currencyconverter.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.currencyconverter.R
import com.example.currencyconverter.utils.FlagList

class CurrencyAdapter(
    context: Context,
    flagList: ArrayList<FlagList>,
    resourceId: Int = 0
) : ArrayAdapter<FlagList>(context, resourceId, flagList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        return super.getView(position, convertView, parent)
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initDropDownView(position, convertView, parent)
    }


    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(
                R.layout.spinner_content, parent, false
            )
        }

        val flagImage: ImageView = view!!.findViewById(R.id.flagImage)
        val flagText: TextView = view.findViewById(R.id.eur_tv)

        val currentItem = getItem(position)



        if (currentItem != null) {
            Glide.with(flagImage.context)
                .load(currentItem.flagImage)
                .into(flagImage)

            flagText.text = currentItem.name
        }

        return view
    }

    private fun initDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(
                R.layout.spinner_row, parent, false
            )
        }

        val flagImage: ImageView = view!!.findViewById(R.id.flagImage)
        val flagText: TextView = view.findViewById(R.id.eur_tv)

        val currentItem = getItem(position)



        if (currentItem != null) {
            Glide.with(flagImage.context)
                .load(currentItem.flagImage)
                .into(flagImage)

            flagText.text = currentItem.name
        }

        return view
    }

}