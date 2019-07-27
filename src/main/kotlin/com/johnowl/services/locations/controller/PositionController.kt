package com.johnowl.services.locations.controller

import com.johnowl.services.locations.model.Position
import com.johnowl.services.locations.model.PositionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PositionController {

    private val positionService: PositionService

    @Autowired
    constructor(service: PositionService) {
        this.positionService = service
    }

    @PostMapping("/")
    fun save(@RequestBody position: Position): ResponseEntity<Position> {
        return ResponseEntity(positionService.save(position), HttpStatus.OK)
    }

    @GetMapping("/{reference}")
    fun getAllByReference(@PathVariable("reference") reference: String): ResponseEntity<List<Position>> {
        return ResponseEntity(positionService.getPositionsByReference(reference), HttpStatus.OK)
    }

    @GetMapping("/{reference}/last")
    fun getLastPosition(@PathVariable("reference") reference: String): ResponseEntity<Position> {
        return ResponseEntity(positionService.getLastPosition(reference), HttpStatus.OK)
    }

    @GetMapping("/")
    fun getPositionsNear(lat: Double, long: Double, maxDistance: Double): ResponseEntity<List<Position>> {
        return ResponseEntity(positionService.getPositionsNear(lat, long, maxDistance), HttpStatus.OK)
    }
}