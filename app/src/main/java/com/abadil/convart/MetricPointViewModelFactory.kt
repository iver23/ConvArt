package com.abadil.convart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abadil.convart.database.MetricPointRepo
import java.lang.IllegalArgumentException

class MetricPointViewModelFactory(private var repo: MetricPointRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MetricPointViewModel::class.java)){
            return MetricPointViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}