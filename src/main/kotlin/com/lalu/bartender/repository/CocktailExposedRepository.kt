package com.lalu.bartender.repository

import com.lalu.bartender.domain.Cocktail
import com.lalu.bartender.domain.mapper.CocktailMapper
import com.lalu.bartender.repository.specification.ExposedSpecification
import com.lalu.bartender.repository.specification.Specification
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Component
import java.sql.Connection

@Suppress("UNCHECKED_CAST")
@Component
class CocktailExposedRepository : Repository<Cocktail> {

    init {
        Database.connect("jdbc:sqlite:/Workspaces/IdeaProjects/temp/bartender.db", "org.sqlite.JDBC")
        TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE

        transaction {
            SchemaUtils.createMissingTablesAndColumns(com.lalu.bartender.domain.entity.Cocktails)
            SchemaUtils.createMissingTablesAndColumns(com.lalu.bartender.domain.entity.CocktailIngredients)
            SchemaUtils.createMissingTablesAndColumns(com.lalu.bartender.domain.entity.Ingredients)
            SchemaUtils.createMissingTablesAndColumns(com.lalu.bartender.domain.entity.Measurements)
        }
    }

    override fun add(item: Cocktail) {
        transaction {
            addLogger(StdOutSqlLogger)

            CocktailMapper.map(item)
        }
    }

    override fun add(items: Iterable<Cocktail>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(item: Cocktail) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(item: Cocktail) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(items: Iterable<Cocktail>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun query(specification: Specification): List<Cocktail> {
        val exposedSpecification = specification as ExposedSpecification<com.lalu.bartender.domain.dto.Cocktail>
        return transaction {
            listOf(CocktailMapper.map(exposedSpecification.retrieve()))
        }
    }
}