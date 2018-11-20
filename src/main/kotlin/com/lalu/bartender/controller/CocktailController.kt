package com.lalu.bartender.controller

import com.lalu.bartender.domain.dto.Cocktail
import com.lalu.bartender.repository.CocktailExposedRepository
import com.lalu.bartender.service.CocktailServiceManager
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/cocktails")
class CocktailController(var cocktailServiceManager: CocktailServiceManager) {
    //val repository = CocktailExposedRepository()

    /*init { //TODO remove init
        repository.add(com.lalu.bartender.domain.Cocktail(
                title = "Gin Mule",
                preparation = "Put the ingredient in the glass and drink",
                ingredients = listOf(com.lalu.bartender.domain.CocktailIngredient(
                        ingredient = com.lalu.bartender.domain.Ingredient("Gin"),
                        measurement = com.lalu.bartender.domain.Measurement(BigDecimal(3.00), "oz")
                ))
        ))
    } */

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") id: Int): com.lalu.bartender.domain.Cocktail {
        return cocktailServiceManager.findById(id)
    }

}