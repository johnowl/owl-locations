package com.johnowl.services.locations.model

import java.math.BigDecimal

interface PositionRepository {
    fun save(position: Position): Position
    fun findFirstByReferenceOrderByCreatedAtDesc(reference: String): Position
    fun getByReferenceOrderByCreatedAtDesc(reference: String): List<Position>
    fun findAllNear(latitude: Double, longitude: Double, maxDistance: Double): List<Position>
}