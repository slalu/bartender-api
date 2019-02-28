package com.lalu.bartender.repository.specification

import com.lalu.bartender.domain.dto.Cocktail

interface ExposedSpecification<T> : Specification {
    fun retrieve(): Cocktail?
}
