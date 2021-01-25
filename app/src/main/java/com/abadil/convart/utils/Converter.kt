package com.abadil.convart.utils

import com.abadil.convart.data.MetricPoint
import com.abadil.convart.data.PolarPoint
import kotlin.math.*

object Converter {

    @JvmStatic
    fun convert(pointOrigine: MetricPoint, objectif: PolarPoint, pointCible: MetricPoint): PolarPoint{
        return calculatePolarCoord(calculateMetricCoord(pointOrigine, objectif), pointCible)
    }

    private fun calculateMetricCoord(origine: MetricPoint, objectif: PolarPoint): MetricPoint{
        val radianGisement: Double = (objectif.gisement * PI) / 3200

        val dx = objectif.distance * sin(radianGisement)
        val dy = objectif.distance * cos(radianGisement)

        val xObj: Float = (origine.x + dx).toFloat()
        val yObj: Float = (origine.y + dy).toFloat()

        return MetricPoint("Obj", xObj, yObj)
    }

    private fun calculatePolarCoord(objectif: MetricPoint, cible: MetricPoint): PolarPoint{
        val gisObj: Float

        val dx: Float = objectif.x - cible.x
        val dy: Float = objectif.y - cible.y

        val disObj: Float = sqrt(dx.pow(2) + dy.pow(2))

        val angleObj = atan(abs(dx / dy)) * (3200 / PI)

        gisObj = when {
            (dx > 0) and (dy > 0) -> {
                angleObj.toFloat()
            }
            (dx > 0) and (dy < 0) -> {
                (3200 - angleObj).toFloat()
            }
            (dx < 0) and (dy < 0) -> {
                (3200 + angleObj).toFloat()
            }
            else -> {
                (6400 - angleObj).toFloat()
            }
        }
        return PolarPoint(gisObj, disObj)
    }


}