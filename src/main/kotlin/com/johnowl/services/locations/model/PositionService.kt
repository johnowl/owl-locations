package com.johnowl.services.locations.model

import org.springframework.stereotype.Service

@Service
class PositionService(private val positionRepository: PositionRepository) {

    fun save(position: Position): Position {
        return positionRepository.save(position)
    }

    fun getLastPosition(reference: String): Position {
        return positionRepository.findFirstByReferenceOrderByCreatedAtDesc(reference)
    }

    fun getPositionsByReference(reference: String): List<Position> {
        return positionRepository.getByReferenceOrderByCreatedAtDesc(reference)
    }

    fun getPositionsNear(latitude: Double, longitude: Double, maxDistanceInMeters: Double): List<Position> {
        return positionRepository.findAllNear(latitude, longitude, maxDistanceInMeters)
    }
}