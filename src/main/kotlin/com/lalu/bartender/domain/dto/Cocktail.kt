package com.lalu.bartender.domain.dto

import com.lalu.bartender.domain.entity.CocktailIngredients
import com.lalu.bartender.domain.entity.Cocktails
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Cocktail(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Cocktail>(Cocktails)

    var title by Cocktails.title
    var preparation by Cocktails.preparation
    var cocktailIngredients by CocktailIngredient via CocktailIngredients
}