package com.lalu.bartender.repository

import com.lalu.bartender.domain.Cocktail
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.math.BigDecimal

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class CocktailExposedRepositoryTest {

    @Autowired
    private lateinit var repository: Repository<Cocktail>

    @Test
    fun shouldAddCocktail() {
        var cocktail = com.lalu.bartender.domain.Cocktail(
                title = "Gin Mule",
                preparation = "Put the ingredient in the glass and drink",
                ingredients = listOf(com.lalu.bartender.domain.CocktailIngredient(
                        ingredient = com.lalu.bartender.domain.Ingredient("Gin"),
                        measurement = com.lalu.bartender.domain.Measurement(BigDecimal(3.00), "oz")
                )))

        repository.add(cocktail)
    }

    //TODO test the get since it throws an exception
}
