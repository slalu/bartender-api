package com.lalu.bartender.controller

import com.lalu.bartender.domain.Cocktail
import com.lalu.bartender.exceptions.CocktailNotFoundException
import com.lalu.bartender.service.CocktailServiceManager
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class CocktailControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var cocktailServiceManager: CocktailServiceManager

    @Test
    fun shouldGetCocktailById() {
        val cocktail = Cocktail(1, "Gin", emptyList(),"")
        
        given(cocktailServiceManager.findById(1)).willReturn(cocktail)

        mockMvc.perform(get("/cocktails/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.title").value("Gin"))

    }

    @Test
    fun shouldFailWhenGetCocktailByIdDoesNotExist() {
        given(cocktailServiceManager.findById(1)).willThrow(CocktailNotFoundException("Cocktail not found"))

        mockMvc.perform(get("/cocktails/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isNotFound)
    }
}