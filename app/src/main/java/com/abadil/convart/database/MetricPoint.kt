package com.abadil.convart.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_points")
data class MetricPoint(@ColumnInfo(name = "point_id") @PrimaryKey val _id: String,
                       @ColumnInfo(name = "point_x") val x: Float,
                       @ColumnInfo(name = "point_y") val y: Float){

}