package com.abadil.convart.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MetricPoint::class], version = 1, exportSchema = false)
abstract class MetricPointDB : RoomDatabase() {
    abstract val metricCoordDao : MetricPointDao

    companion object {
        @Volatile
        private var INSTANCE : MetricPointDB? = null
        fun getInstance(context: Context): MetricPointDB{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,
                        MetricPointDB::class.java,
                        "metricPoint_db")
                        .build()
                }
                return instance
            }
        }
    }
}