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

//    @Query(value ="{ \"location\" : { \"\$nearSphere\" : { \"x\" : ?1, \"y\" : ?0 }, \"\$maxDistance\" : ?2 } }")
//    override fun findAllNear(latitude: Double, longitude: Double, maxDistanceInMeters: Double): List<Position>
}