package com.seungho.cafe.domain

import java.time.LocalDateTime

data class Order (
    val id: Long,
    val menuId: Long,
    val menuName: String,
    val quantity: Int,
    val totalPrice: Long,
    val orderTime: LocalDateTime = LocalDateTime.now()
)