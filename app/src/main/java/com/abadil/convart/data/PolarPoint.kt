package com.abadil.convart.data

data class PolarPoint(val gisement: Float, val distance: Float){
    override fun toString(): String {
        return "Gisement: $gisement\nDistance: $distance"
    }
}