package com.lalu.bartender.domain.entity

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column

object Cocktails : IntIdTable() {
    val title: Column<String> = varchar("title", 150)
    val preparation: Column<String> = text("preparation")
}