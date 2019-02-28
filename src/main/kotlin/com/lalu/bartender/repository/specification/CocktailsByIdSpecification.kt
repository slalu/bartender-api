package com.lalu.bartender.repository.specification

import com.lalu.bartender.domain.dto.Cocktail

class CocktailsByIdSpecification(val id: Int) : ExposedSpecification<Cocktail> {
    override fun retrieve(): Cocktail? {
        return Cocktail.findById(id)
    }

    override fun equals(other: Any?): Boolean {
        return if (other is CocktailsByIdSpecification) this.id == other.id else super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}