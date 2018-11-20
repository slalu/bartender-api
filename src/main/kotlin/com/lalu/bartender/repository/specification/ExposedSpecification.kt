package com.lalu.bartender.repository.specification

interface ExposedSpecification<T> : Specification {
    fun retrieve(): T
}
