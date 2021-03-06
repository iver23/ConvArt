package com.abadil.convart.database

import com.abadil.convart.data.MetricPoint

class MetricPointRepo(private val dao: MetricPointDao) {

    val points = dao.getAllPoints()

    suspend fun insert(point: MetricPoint){
        dao.insertPoint(point)
    }

    suspend fun update(point: MetricPoint){
        dao.updatePoint(point)
    }

    suspend fun delete(point: MetricPoint){
        dao.deletePoint(point)
    }

}