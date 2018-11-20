package com.lalu.bartender.domain.entity

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column

object Ingredients : IntIdTable() {
    val name: Column<String> = varchar("name", 150)
}