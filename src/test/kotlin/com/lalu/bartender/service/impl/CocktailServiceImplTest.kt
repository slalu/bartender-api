package com.lalu.bartender.service.impl

import com.lalu.bartender.domain.Cocktail
import com.lalu.bartender.exceptions.CocktailNotFoundException
import com.lalu.bartender.repository.Repository
import com.lalu.bartender.repository.specification.CocktailsByIdSpecification
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CocktailServiceImplTest {
    @InjectMocks
    private lateinit var cocktailService: CocktailServiceImpl

    @Mock
    private lateinit var cocktailRepository: Repository<Cocktail>

    @Test
    fun shouldGetCocktailById() {
        val cocktail = Cocktail(1, "Gin", emptyList(), "")

        Mockito.`when`(cocktailRepository.query(CocktailsByIdSpecification(1))).thenReturn(listOf(cocktail))

        val resultCocktail = cocktailService.findById(1)

        Mockito.verify(cocktailRepository).query(CocktailsByIdSpecification(1))

        assertThat(resultCocktail).isNotNull
        assertThat(resultCocktail.title).isEqualTo("Gin")
    }

    @Test(expected = CocktailNotFoundException::class)
    fun shouldFailWhenGetCocktailByIdDoesNotExist() {
        Mockito.`when`(cocktailRepository.query(CocktailsByIdSpecification(1))).thenReturn(emptyList())

        cocktailService.findById(1)

        Mockito.verify(cocktailRepository).query(CocktailsByIdSpecification(1))
    }

    @Test
    fun shouldSaveCocktail() {
        val cocktail = Cocktail(1, "Gin", emptyList(), "")

        cocktailService.save(cocktail)
        Mockito.verify(cocktailRepository).add(cocktail)
    }
}