package com.yeojin.cafe.controller;

import com.yeojin.cafe.dto.OrderResponseDto;
import com.yeojin.cafe.dto.OrderRequestDto;
import com.yeojin.cafe.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    // 주문 생성 - POST /api/orders
    @PostMapping
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto requestDto) {
        return orderService.createOrder(requestDto);
    }

    // 주문 조회 - GET /api/orders/{orderId}
    @GetMapping("/{orderId}")
    public OrderResponseDto getOrder(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }
}
