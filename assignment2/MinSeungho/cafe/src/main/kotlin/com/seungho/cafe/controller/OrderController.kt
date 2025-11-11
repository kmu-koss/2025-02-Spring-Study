package com.seungho.cafe.controller

import com.seungho.cafe.dto.OrderRequest
import com.seungho.cafe.dto.OrderResponse
import com.seungho.cafe.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/orders")
class OrderController (
    private val orderService: OrderService
){
    @PostMapping
    fun placeOrder(@RequestBody request: OrderRequest): ResponseEntity<OrderResponse> {
        val orderResponse = orderService.placeOrder(request)

        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse)
    }

    @GetMapping("/{orderId}")
    fun getOrderDetails(@PathVariable orderId: Long) : ResponseEntity<OrderResponse> {
        val orderResponse = orderService.getOrderDetails(orderId)
        return ResponseEntity.ok(orderResponse)
    }
}