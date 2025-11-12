package com.yeojin.cafe.repository;

import com.yeojin.cafe.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrderRepository {
    private final Map<Long, Order> orderStore = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    // 주문 저장
    public Order saveOrder(Order order) {
        order.setId(sequence.getAndIncrement());
        orderStore.put(order.getId(), order);
        return order;
    }

    // order ID로 조회
    public Optional<Order> findOrderById(Long id) {
        return Optional.ofNullable(orderStore.get(id));
    }
}
