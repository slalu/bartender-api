package com.lalu.bartender.domain

data class Cocktail(val id : Int = -1,
                    val title: String,
                    val ingredients: List<CocktailIngredient>,
                    val preparation: String)