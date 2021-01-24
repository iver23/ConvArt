package com.abadil.convart.ui

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abadil.convart.database.MetricPointRepo

class FragmentConvertViewModel(private val repo: MetricPointRepo) : ViewModel(), Observable {
    val points = repo.points
    private val _isCoordIncorrect = MutableLiveData<Boolean>()
    val isCoordIncorrect: LiveData<Boolean>
        get() = _isCoordIncorrect


    @Bindable
    val inputGisement = MutableLiveData<String>()

    @Bindable
    val inputDistance = MutableLiveData<String>()

    fun calculate() {
        if ((inputGisement.value == null) or (inputGisement.value!!.toFloat() > 6400)) {
            _isCoordIncorrect.value = true
            return
        }
        val gisement = inputGisement.value!!.trim().toFloat()

        if (inputDistance.value == null){
            _isCoordIncorrect.value = true
            return
        }
        val distance = inputDistance.value!!.trim().toFloat()
        inputGisement.value = null
        inputDistance.value = null
    }

    fun resetError(){
        _isCoordIncorrect.value = null
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}