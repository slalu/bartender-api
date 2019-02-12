package com.lalu.bartender.controller

import com.lalu.bartender.service.CocktailServiceManager
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cocktails")
class CocktailController(var cocktailServiceManager: CocktailServiceManager) {
    
    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") id: Int): com.lalu.bartender.domain.Cocktail {
        return cocktailServiceManager.findById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody cocktail: Cocktail) : Cocktail {
        return cocktailServiceManager.save(cocktail)
    }

}