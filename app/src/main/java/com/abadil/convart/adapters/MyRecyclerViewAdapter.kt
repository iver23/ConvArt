package com.abadil.convart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.abadil.convart.R
import com.abadil.convart.data.MetricPoint
import com.abadil.convart.databinding.RecyclerviewItemBinding

class MyRecyclerViewAdapter(private var pointsList: MutableList<MetricPoint>): RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RecyclerviewItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.recyclerview_item, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(pointsList[position])
    }

    override fun getItemCount(): Int {
        return pointsList.size
    }

    fun getPointAtPosition(position: Int): MetricPoint {
        return pointsList[position]
    }

    fun undoDelete(point: MetricPoint, position: Int){
        pointsList.add(position, point)
        notifyItemInserted(position)
    }

}

class MyViewHolder(private val binding: RecyclerviewItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(point: MetricPoint){
        binding.idTv.text = point._id
        binding.xTv.text = "%.0f".format(point.x)
        binding.yTv.text = "%.0f".format(point.y)

    }


}