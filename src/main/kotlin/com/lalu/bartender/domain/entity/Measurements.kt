package com.lalu.bartender.domain.entity

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import java.math.BigDecimal

object Measurements : IntIdTable() {
    val quantity: Column<BigDecimal> = decimal("quantity", 5, 2)
    val unit: Column<String> = varchar("unit", 150)
}
