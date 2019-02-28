package com.lalu.bartender.repository.specification

import com.lalu.bartender.domain.dto.Cocktail
import com.lalu.bartender.domain.entity.Cocktails

class CocktailsByTitleSpecification(val title: String) : ExposedSpecification<Cocktail> {
    override fun retrieve(): List<Cocktail> {
        return Cocktail.find { Cocktails.title eq title }.toList()
    }

    override fun equals(other: Any?): Boolean {
        return if (other is CocktailsByTitleSpecification) this.title == other.title else super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}