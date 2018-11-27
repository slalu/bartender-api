package com.lalu.bartender

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BartenderServiceApplication

//References
//Google API naming conventions: https://cloud.google.com/apis/design/naming_convention
//Exposed - Kotlin SQL Library: https://github.com/JetBrains/Exposed
//Useful example: https://stackoverflow.com/questions/50339016/kotlin-exposed-dsl-query-mapping

//Cocktail creation example
//val repository = CocktailExposedRepository()
/*init {
    repository.add(com.lalu.bartender.domain.Cocktail(
            title = "Gin Mule",
            preparation = "Put the ingredient in the glass and drink",
            ingredients = listOf(com.lalu.bartender.domain.CocktailIngredient(
                    ingredient = com.lalu.bartender.domain.Ingredient("Gin"),
                    measurement = com.lalu.bartender.domain.Measurement(BigDecimal(3.00), "oz")
            ))
    ))
} */

fun main(args: Array<String>) {
    runApplication<BartenderServiceApplication>(*args)
}
