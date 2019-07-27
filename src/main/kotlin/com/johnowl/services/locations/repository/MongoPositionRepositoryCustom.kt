package com.johnowl.services.locations.repository

import com.johnowl.services.locations.model.Position

interface MongoPositionRepositoryCustom {
    fun findAllNear(latitude: Double, longitude: Double, maxDistanceInMeters: Double): List<Position>
}