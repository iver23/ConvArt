package com.abadil.convart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abadil.convart.database.MetricPointRepo
import com.abadil.convart.ui.FragmentListViewModel
import java.lang.IllegalArgumentException

class FragmentListViewModelFactory(private var repo: MetricPointRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FragmentListViewModel::class.java)){
            return FragmentListViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}