package com.lalu.bartender.service

import com.lalu.bartender.domain.Cocktail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CocktailServiceManager {

    @Autowired
    private lateinit var cocktailService : CocktailService

    fun findById(id: Int) : Cocktail {
        return cocktailService.findById(id)
    }
}