package com.lalu.bartender.service

import com.lalu.bartender.domain.Cocktail
import com.lalu.bartender.service.impl.CocktailServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CocktailServiceManager {

    @Autowired
    private lateinit var cocktailService : CocktailServiceImpl

    fun findById(id: Int) : Cocktail {
        return cocktailService.findById(id)
    }
}