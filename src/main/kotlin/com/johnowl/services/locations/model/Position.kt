package com.johnowl.services.locations.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("positions")
data class Position(
        @Id val id: String,
        val reference: String, // this field is an id of a thing in another service, can be a car id, a person id, etc
        val location: Location,
        val createdAt: LocalDateTime = LocalDateTime.now()
)