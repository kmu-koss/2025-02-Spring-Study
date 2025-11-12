package com.yeojin.cafe.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// 주문 완료 후 클라이언트에게 보내는 응답 데이터

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
    private Long orderId; // 주문 id
    private Long menuId; // 메뉴 id
    private int quantity; // 수량
}
