package com.johnowl.services.locations.repository

import com.johnowl.services.locations.model.Position
import com.johnowl.services.locations.model.PositionRepository
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
interface MongoPositionRepository : MongoRepository<Position, String>, PositionRepository, MongoPositionRepositoryCustom {

    override fun save(position: Position): Position
    override fun findFirstByReferenceOrderByCreatedAtDesc(reference: String): Position
    override fun getByReferenceOrderByCreatedAtDesc(reference: String): List<Position>
}