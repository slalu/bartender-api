package com.lalu.bartender.repository

import com.lalu.bartender.repository.specification.Specification
import org.springframework.stereotype.Component

public interface Repository<T> {
    fun add(item: T)

    fun add(items: Iterable<T>)

    fun update(item: T)

    fun remove(item: T)

    fun remove(items: Iterable<T>)

    fun query(specification: Specification): List<T>
}
