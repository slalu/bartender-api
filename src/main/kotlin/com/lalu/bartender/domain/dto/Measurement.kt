package com.lalu.bartender.domain.dto

import com.lalu.bartender.domain.entity.Measurements
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Measurement(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Measurement>(table = Measurements)

    var quantity by Measurements.quantity
    var unit by Measurements.unit
}
