package com.seungho.cafe.dto

import com.seungho.cafe.domain.Order
import java.time.LocalDateTime

// 주문 시 응답
data class OrderResponse(
    val orderId: Long,
    val menuName: String,
    val quantity: Int,
    val totalPrice: Long,
    val orderTime: LocalDateTime
) {
    companion object {
        fun from(order: Order): OrderResponse {
            return OrderResponse(
                orderId = order.menuId,
                menuName = order.menuName,
                quantity = order.quantity,
                totalPrice = order.totalPrice,
                orderTime = order.orderTime
            )
        }
    }
}
