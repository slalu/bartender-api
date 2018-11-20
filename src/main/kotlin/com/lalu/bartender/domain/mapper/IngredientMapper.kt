package com.lalu.bartender.domain.mapper

import com.lalu.bartender.domain.Ingredient

class IngredientMapper {
    companion object {
        fun map(ingredient: com.lalu.bartender.domain.dto.Ingredient): Ingredient {
            return Ingredient(name = ingredient.name)
        }

        fun map(ingredient: Ingredient): com.lalu.bartender.domain.dto.Ingredient {
            return com.lalu.bartender.domain.dto.Ingredient.new {
                name = ingredient.name
            }
        }
    }
}