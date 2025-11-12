package com.yeojin.cafe.service;

import com.yeojin.cafe.domain.Menu;
import com.yeojin.cafe.domain.Order;
import com.yeojin.cafe.dto.OrderResponseDto;
import com.yeojin.cafe.dto.OrderRequestDto;
import com.yeojin.cafe.repository.MenuRepository;
import com.yeojin.cafe.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;

    // 주문 생성
    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        // 1. 메뉴가 존재하는지 확인
        Optional<Menu> menuOptional = menuRepository.findMenuById(requestDto.getMenuId());
        if (menuOptional.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 메뉴입니다. menuId: " + requestDto.getMenuId());
        }

        // 2. Order 엔티티 생성
        Order order = new Order();
        order.setMenuId(requestDto.getMenuId());
        order.setQuantity(requestDto.getQuantity());

        // 3. Order 저장
        Order savedOrder = orderRepository.saveOrder(order);

        // 4. Entity -> DTO 변환하여 반환
        return new OrderResponseDto(
                savedOrder.getId(),
                savedOrder.getMenuId(),
                savedOrder.getQuantity()
        );
    }

    // 주문 조회
    public OrderResponseDto getOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findOrderById(orderId);

        if (orderOptional.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 주문입니다. orderId: " + orderId);
        }

        Order order = orderOptional.get();

        // Entity -> DTO 변환하여 반환
        return new OrderResponseDto(
                order.getId(),
                order.getMenuId(),
                order.getQuantity()
        );
    }
}
