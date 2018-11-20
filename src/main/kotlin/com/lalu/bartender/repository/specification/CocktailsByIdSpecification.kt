package com.lalu.bartender.repository.specification

import com.lalu.bartender.domain.dto.Cocktail

class CocktailsByIdSpecification(val id: Int) : ExposedSpecification<Cocktail> {
    override fun retrieve(): Cocktail {
        return Cocktail[id]
    }
}