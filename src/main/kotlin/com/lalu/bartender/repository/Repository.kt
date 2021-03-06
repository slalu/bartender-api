package com.lalu.bartender.repository

import com.lalu.bartender.repository.specification.Specification

public interface Repository<T> {
    fun add(item: T)

    fun add(items: Iterable<T>)

    fun update(item: T)

    fun remove(specification: Specification)

    fun query(specification: Specification): List<T>
}
