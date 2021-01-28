package com.abadil.convart.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.abadil.convart.R
import com.abadil.convart.data.MetricPoint


class PointsSpinnerAdapter(context: Context, private val unitsList: List<MetricPoint>) : ArrayAdapter<MetricPoint>(context, 0, unitsList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getCount(): Int = unitsList.size
    override fun getItem(position: Int): MetricPoint = unitsList[position]
    override fun getItemId(position: Int): Long = position.toLong()


    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(parent.context)
        //val binding: CustomSpinnerItemLayoutBinding = DataBindingUtil.inflate(layoutInflater, R.layout.custom_spinner_item_layout, parent, false)
        val view = convertView ?: layoutInflater.inflate(R.layout.custom_spinner_item_layout, parent, false)
        val point = getItem(position)
        val textView = view.findViewById<TextView>(R.id.spinner_item)
        textView.text = point._id
        //binding.spinnerItem.text = point._id
        return view
    }
}