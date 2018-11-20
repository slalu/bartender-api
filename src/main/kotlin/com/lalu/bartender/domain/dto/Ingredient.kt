package com.lalu.bartender.domain.dto

import com.lalu.bartender.domain.entity.Ingredients
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Ingredient(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Ingredient>(table = Ingredients)

    var name by Ingredients.name
}