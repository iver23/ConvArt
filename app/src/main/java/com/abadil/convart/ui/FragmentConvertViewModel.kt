package com.abadil.convart.ui

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abadil.convart.database.MetricPointRepo

class FragmentConvertViewModel(private val repo: MetricPointRepo) : ViewModel() {
    val points = repo.points
    private val _isEmpty = MutableLiveData<Boolean>()
    val isEmpty: LiveData<Boolean>
        get() = _isEmpty
    private val _isGisementIncorrect = MutableLiveData<Boolean>()
    val isGisementIncorrect: LiveData<Boolean>
        get() = _isGisementIncorrect

    @Bindable
    val inputGisement = MutableLiveData<String>()

    @Bindable
    val inputDistance = MutableLiveData<String>()

    fun calculate() {
        if (inputGisement.value == null) {
            _isEmpty.value = true
            return
        } else if (inputGisement.value!!.toFloat() > 6400) {
            _isGisementIncorrect.value = true
            return
        }
        val gisement = inputGisement.value!!.trim().toFloat()

        if (inputDistance.value == null){
            _isEmpty.value = true
            return
        }
        val distance = inputDistance.value!!.trim().toFloat()
    }

    fun resetError(){
        _isEmpty.value = null
        _isGisementIncorrect.value = null
    }
}