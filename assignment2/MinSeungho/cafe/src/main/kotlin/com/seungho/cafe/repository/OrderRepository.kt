package com.seungho.cafe.repository

import com.seungho.cafe.domain.Order
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong

@Repository
class OrderRepository {
    private val store = ConcurrentHashMap<Long, Order>()
    private val sequence = AtomicLong(0L)

    fun save(order: Order): Order {
        val newId = sequence.incrementAndGet()
        val newOrder = order.copy(id = newId)
        store[newId] = newOrder
        return newOrder
    }

    fun findById(id: Long): Order? {
        return store[id]
    }

    fun findAll(): List<Order> {
        return store.values.toList()
    }
}