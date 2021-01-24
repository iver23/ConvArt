package com.abadil.convart.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.abadil.convart.data.MetricPoint

@Dao
interface MetricPointDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPoint(point: MetricPoint)

    @Update
    suspend fun updatePoint(point: MetricPoint)

    @Delete
    suspend fun deletePoint(point: MetricPoint)

    @Query("SELECT * FROM list_points")
    fun getAllPoints(): LiveData<List<MetricPoint>>

}