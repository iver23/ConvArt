package com.abadil.convart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.abadil.convart.database.MetricPoint
import com.abadil.convart.databinding.CustomSpinnerItemLayoutBinding


class PointsSpinnerAdapter(context: Context, unitsList: List<MetricPoint>): ArrayAdapter<MetricPoint>(context,0, unitsList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CustomSpinnerItemLayoutBinding = DataBindingUtil.inflate(layoutInflater, R.layout.custom_spinner_item_layout, parent, false)
        val point = getItem(position)
        val view = convertView ?: binding.root
        binding.spinnerItem.text = point?._id
        return view
    }
}