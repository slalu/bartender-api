package com.lalu.bartender.domain.entity

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column

object CocktailIngredients : IntIdTable() {
    val cocktail:  Column<EntityID<Int>> = reference("cocktail", Cocktails)
    val ingredient: Column<EntityID<Int>> = reference("ingredient", Ingredients)
    val measurement: Column<EntityID<Int>> = reference("measurement", Measurements)
}