package com.abadil.convart.ui

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abadil.convart.data.MetricPoint
import com.abadil.convart.database.MetricPointRepo
import kotlinx.coroutines.launch

class FragmentListViewModel(private val repo: MetricPointRepo): ViewModel(), Observable {

    val points = repo.points
    private val _isEmpty = MutableLiveData<Boolean>()
    val isEmpty : LiveData<Boolean>
        get() = _isEmpty

    @Bindable
    val inputDesignation = MutableLiveData<String>()

    @Bindable
    val inputX = MutableLiveData<String>()

    @Bindable
    val inputY = MutableLiveData<String>()



    fun addPoint(){
        if(inputDesignation.value == null){
            _isEmpty.value = true
            return
        }
        val id = inputDesignation.value!!.trim()

        if(inputX.value == null){
            _isEmpty.value = true
            return
        }
        val x = inputX.value!!.trim().toFloat()

        if(inputY.value == null){
            _isEmpty.value = true
            return
        }
        val y = inputY.value!!.trim().toFloat()

        insert(MetricPoint(id, x , y))
        inputDesignation.value = null
        inputX.value = null
        inputY.value = null
    }

    //since showing a error message is an event and not a state, reset it once its done
    fun resetError(){
        _isEmpty.value = null
    }

    fun insert(point: MetricPoint) = viewModelScope.launch { repo.insert(point) }

    fun update(point: MetricPoint) = viewModelScope.launch { repo.update(point) }

    fun delete(point: MetricPoint) = viewModelScope.launch { repo.delete(point) }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}