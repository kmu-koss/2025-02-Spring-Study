package com.yeojin.cafe.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// 클라이언트가 주문할 때 보내는 요청 데이터 (POST)

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    private Long menuId; // 메뉴 id
    private int quantity; // 수량
}
