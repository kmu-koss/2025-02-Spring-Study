package com.seungho.cafe.repository

import com.seungho.cafe.domain.Menu
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong
import kotlin.collections.set

@Repository
class MenuRepository {
    private val store = ConcurrentHashMap<Long, Menu>()
    private val sequence = AtomicLong(0L)

    @PostConstruct // 메뉴 초기 등록
    fun init() {
        save(Menu(id = -1L, name = "아메리카노", price = 2000L)) // 임시 ID
        save(Menu(id = -1L, name = "카페라떼", price = 3500L))
        save(Menu(id = -1L, name = "유자차", price = 3000L))
    }

    fun save(menu: Menu): Menu {
        val newId = sequence.incrementAndGet()
        val newMenu = menu.copy(id = newId)
        store[newId] = newMenu
        return newMenu
    }

    fun findById(id: Long): Menu? {
        return store[id]
    }

    fun findAll(): List<Menu> {
        return store.values.toList()
    }
}