package com.johnowl.services.locations.model

import org.junit.Assert.assertEquals
import org.junit.Test

class HaversineAlgorithmTest {

    private val service = HaversineAlgorithm()

    @Test
    fun `should calculate distance between zeroes coordinates`() {
        val lat1 = 0.0
        val lng1 = 0.0
        val lat2 = 0.0
        val lng2 = 0.0

        val distance = service.calculateDistanceInKm(lat1, lng1, lat2, lng2)

        assertEquals(0.00, distance, 0.01)
    }

    @Test
    fun `should calculate distance in Km between Masp and Pedro Alvarez Cabral monument`() {


        val masp = Location(-46.6558819, -23.561414)
        val monument = Location(-46.6603451, -23.5814255)

        val distance = service.calculateDistanceInKm(
                masp.latitude,
                masp.longitude,
                monument.latitude,
                monument.longitude
        )

        assertEquals(2.27, distance, 0.01)
    }

    @Test
    fun `should calculate distance in meters between Masp and Pedro Alvarez Cabral monument`() {


        val masp = Location(-46.6558819, -23.561414)
        val monument = Location(-46.6603451, -23.5814255)

        val distance = service.calculateDistanceInMeters(
                masp.latitude,
                masp.longitude,
                monument.latitude,
                monument.longitude
        )

        assertEquals(2273, distance)
    }

}