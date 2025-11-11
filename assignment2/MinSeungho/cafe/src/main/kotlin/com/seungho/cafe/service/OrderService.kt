package com.seungho.cafe.service

import com.seungho.cafe.domain.Order
import com.seungho.cafe.dto.OrderRequest
import com.seungho.cafe.dto.OrderResponse
import com.seungho.cafe.repository.MenuRepository
import com.seungho.cafe.repository.OrderRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class OrderService (
    val orderRepository: OrderRepository,
    val menuRepository: MenuRepository
){
    fun placeOrder(request: OrderRequest): OrderResponse {
        val menu = menuRepository.findById(request.menuId)
            ?: throw IllegalArgumentException("No menu with id ${request.menuId}")

        val totalPrice = menu.price * request.quantity

        val newOrder = Order(
            id = -1L,
            menuId = menu.id,
            menuName = menu.name,
            quantity = request.quantity,
            totalPrice = totalPrice,
            orderTime = LocalDateTime.now()
        )

        val savedOrder = orderRepository.save(newOrder)

        return OrderResponse.from(savedOrder)
    }

    fun getOrderDetails(orderId: Long): OrderResponse {
        val order = orderRepository.findById(orderId)
            ?: throw IllegalArgumentException("No matching order with id $orderId")

        return OrderResponse.from(order)
    }
}