package com.johnowl.services.locations.repository

import com.johnowl.services.locations.model.Position
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query.query

class MongoPositionRepositoryImpl : MongoPositionRepositoryCustom {

    private val mongoTemplate: MongoTemplate

    constructor(mongoTemplate: MongoTemplate) {
        this.mongoTemplate = mongoTemplate
    }

    override fun findAllNear(latitude: Double, longitude: Double, maxDistanceInMeters: Double): List<Position> {

        val query = query(where("location")
                .nearSphere(Point(longitude, latitude))
                .maxDistance(maxDistanceInMeters / 6378100))

        return mongoTemplate.find(query, Position::class.java)

    }
}