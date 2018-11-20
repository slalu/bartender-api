package com.lalu.bartender.domain.mapper

import com.lalu.bartender.domain.Cocktail

class CocktailMapper {
    companion object {
        fun map(cocktail: com.lalu.bartender.domain.dto.Cocktail): Cocktail {
            return Cocktail(
                    id = cocktail.id.value,
                    title = cocktail.title,
                    preparation = cocktail.preparation,
                    ingredients = CocktailIngredientMapper.map(cocktail.cocktailIngredients)
            )
        }
        
        fun map(cocktail: Cocktail): com.lalu.bartender.domain.dto.Cocktail {
            val resultCocktail = com.lalu.bartender.domain.dto.Cocktail.new {
                title = cocktail.title
                preparation = cocktail.preparation
            }

            CocktailIngredientMapper.map(cocktail.ingredients, resultCocktail)

            /*transaction {
                resultCocktail.cocktailIngredients = SizedCollection(ingredients)
            }    */

            return resultCocktail
        }
    }
}