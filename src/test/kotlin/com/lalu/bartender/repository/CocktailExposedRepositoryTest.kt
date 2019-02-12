package com.lalu.bartender.repository

import com.lalu.bartender.domain.Cocktail
import com.lalu.bartender.domain.mapper.CocktailMapper
import com.lalu.bartender.repository.specification.CocktailsByIdSpecification
import org.jetbrains.exposed.sql.transactions.transaction

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.math.BigDecimal
import org.assertj.core.api.Assertions.assertThat

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class CocktailExposedRepositoryTest {

    @Autowired
    private lateinit var repository: Repository<Cocktail>

    @Test
    fun shouldAddCocktail() {
        val cocktail = com.lalu.bartender.domain.Cocktail(
                title = "Gin Mule",
                preparation = "Put the ingredient in the glass and drink",
                ingredients = listOf(com.lalu.bartender.domain.CocktailIngredient(
                        ingredient = com.lalu.bartender.domain.Ingredient("Gin"),
                        measurement = com.lalu.bartender.domain.Measurement(BigDecimal(3.00), "oz")
                )))

        repository.add(cocktail)

        val queriedCocktail = transaction {
            CocktailMapper.map(CocktailsByIdSpecification(cocktail.id).retrieve())
        }

        assertThat(queriedCocktail.id).isNotNull()
        assertThat(queriedCocktail.title).isEqualTo(cocktail.title)
    }

    @Test
    fun shouldGetCocktail() {
        val cocktail = com.lalu.bartender.domain.Cocktail(
                title = "Gin Mule",
                preparation = "Put the ingredient in the glass and drink",
                ingredients = listOf(com.lalu.bartender.domain.CocktailIngredient(
                        ingredient = com.lalu.bartender.domain.Ingredient("Gin"),
                        measurement = com.lalu.bartender.domain.Measurement(BigDecimal(3.00), "oz")
                )))

        val persistedCocktail = transaction {
            CocktailMapper.map(cocktail)
        }

        val foundCocktail = repository.query(CocktailsByIdSpecification(persistedCocktail.id.value)).single()
        assertThat(foundCocktail.title).isEqualTo(persistedCocktail.title)
    }
}
