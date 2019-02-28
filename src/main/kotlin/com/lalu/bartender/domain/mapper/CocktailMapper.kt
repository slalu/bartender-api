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

        fun map(cocktails: List<com.lalu.bartender.domain.dto.Cocktail>): List<Cocktail> {
            val resultCocktails = ArrayList<Cocktail>()
            cocktails.forEach {
                resultCocktails.add(Cocktail(
                        id = it.id.value,
                        title = it.title,
                        preparation = it.preparation,
                        ingredients = CocktailIngredientMapper.map(it.cocktailIngredients)
                ))
            }
            return resultCocktails
        }

        fun map(cocktail: Cocktail): com.lalu.bartender.domain.dto.Cocktail {
            val resultCocktail = com.lalu.bartender.domain.dto.Cocktail.new {
                title = cocktail.title
                preparation = cocktail.preparation
            }

            CocktailIngredientMapper.map(cocktail.ingredients, resultCocktail)

            return resultCocktail
        }
    }
}