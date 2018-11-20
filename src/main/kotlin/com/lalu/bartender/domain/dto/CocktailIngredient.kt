package com.lalu.bartender.domain.dto

import com.lalu.bartender.domain.entity.CocktailIngredients
import com.lalu.bartender.domain.entity.Cocktails
import com.lalu.bartender.domain.entity.Ingredients
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.sql.ColumnSet
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.transactions.TransactionManager

class CocktailIngredient(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CocktailIngredient>(table = CocktailIngredients) {
        override val dependsOnTables: ColumnSet = Cocktails.innerJoin(CocktailIngredients).innerJoin(Ingredients)
        override fun createInstance(entityId: EntityID<Int>, row: ResultRow?): CocktailIngredient {
            val tr = TransactionManager.current()
            row?.tryGet(Cocktails.id)?.let {
                Cocktail.wrap(it, row)
            }
            row?.tryGet(Ingredients.id)?.let {
                Measurement.wrap(it, row)
            }

            return super.createInstance(entityId, row)
        }
    }    

    var cocktail by Cocktail referencedOn CocktailIngredients.cocktail
    var measurement by Measurement referencedOn  CocktailIngredients.measurement
    var ingredient by Ingredient referencedOn CocktailIngredients.ingredient
}