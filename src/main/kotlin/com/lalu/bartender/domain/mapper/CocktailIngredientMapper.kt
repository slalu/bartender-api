package com.lalu.bartender.domain.mapper

import com.lalu.bartender.domain.CocktailIngredient
import com.lalu.bartender.domain.dto.Cocktail

class CocktailIngredientMapper {
    companion object {
        fun map(cocktailIngredients: List<CocktailIngredient>, relatedCocktail: Cocktail): Collection<com.lalu.bartender.domain.dto.CocktailIngredient> {
            val ingredients = ArrayList<com.lalu.bartender.domain.dto.CocktailIngredient>()

            cocktailIngredients.forEach { ingredients.add(this.map(it, relatedCocktail)) }

            return ingredients
        }

        private fun map(cocktailIngredient: CocktailIngredient, relatedCocktail: Cocktail): com.lalu.bartender.domain.dto.CocktailIngredient {
            return com.lalu.bartender.domain.dto.CocktailIngredient.new {
                measurement = MeasurementMapper.map(cocktailIngredient.measurement)
                ingredient =  IngredientMapper.map(cocktailIngredient.ingredient)
                cocktail = relatedCocktail
            }
        }


        fun map(cocktailIngredients: Iterable<com.lalu.bartender.domain.dto.CocktailIngredient>): List<CocktailIngredient> {
            val ingredients = ArrayList<CocktailIngredient>()

            cocktailIngredients.forEach { ingredients.add(this.map(it)) }

            return ingredients
        }

        private fun map(cocktailIngredient: com.lalu.bartender.domain.dto.CocktailIngredient): CocktailIngredient {
            return CocktailIngredient(
                    measurement = MeasurementMapper.map(cocktailIngredient.measurement),
                    ingredient = IngredientMapper.map(cocktailIngredient.ingredient)
            )
        }
    }
}