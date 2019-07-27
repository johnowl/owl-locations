package com.johnowl.services.locations.model

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class PositionService {

    private val positionRepository: PositionRepository

    @Autowired
    constructor(positionRepository: PositionRepository) {
        this.positionRepository = positionRepository
    }

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
        // yes, it's not beautiful =/
        // I'm really sad for doing this... but I really tried a lot
        return positionRepository.findAllNear(latitude, longitude, maxDistanceInMeters)
    }
}