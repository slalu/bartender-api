package com.lalu.bartender.service

import com.lalu.bartender.domain.Cocktail
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CocktailServiceManagerTest {
    @InjectMocks
    private lateinit var cocktailServiceManager: CocktailServiceManager

    @Mock
    private lateinit var cocktailService: CocktailService

    @Test
    fun shouldGetCocktailById() {
        val cocktail = Cocktail(1, "Gin", emptyList(), "")

        `when`(cocktailService.findById(1)).thenReturn(cocktail)

        val resultCocktail = cocktailServiceManager.findById(1)

        Mockito.verify(cocktailService).findById(1)
        Assertions.assertThat(resultCocktail).isNotNull
        Assertions.assertThat(resultCocktail.title).isEqualTo("Gin")
    }
}