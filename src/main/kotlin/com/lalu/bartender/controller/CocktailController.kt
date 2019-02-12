package com.lalu.bartender.controller

import com.lalu.bartender.domain.Cocktail
import com.lalu.bartender.service.CocktailServiceManager
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cocktails")
class CocktailController(var cocktailServiceManager: CocktailServiceManager) {

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") id: Int): Cocktail {
        return cocktailServiceManager.findById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody cocktail: Cocktail): Cocktail {
        return cocktailServiceManager.save(cocktail)
    }

}