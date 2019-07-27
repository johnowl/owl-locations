package com.johnowl.services.locations.model

import org.springframework.stereotype.Service
import kotlin.math.*

@Service
class HaversineAlgorithm {

    private val equatorialEarthRadius = 6378.1370
    private val degreeToRadian = Math.PI / 180.0

    fun calculateDistanceInMeters(lat1: Double, long1: Double, lat2: Double, long2: Double): Int {
        return (1000.0 * calculateDistanceInKm(lat1, long1, lat2, long2)).toInt()
    }

    fun calculateDistanceInKm(lat1: Double, long1: Double, lat2: Double, long2: Double): Double {

        val longInDegrees = (long2 - long1) * degreeToRadian
        val latInDegrees = (lat2 - lat1) * degreeToRadian

        val a = sin(latInDegrees / 2.0).pow(2.0) +
                (cos(lat1 * degreeToRadian) * cos(lat2 * degreeToRadian)
                * sin(longInDegrees / 2.0).pow(2.0))

        val c = 2.0 * atan2(sqrt(a), sqrt(1.0 - a))

        return equatorialEarthRadius * c
    }

}