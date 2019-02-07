package com.lalu.bartender.service

import com.lalu.bartender.domain.Cocktail

interface CocktailService {
    fun findById(id: Int): Cocktail
    fun save(cocktail: Cocktail) : Cocktail
}