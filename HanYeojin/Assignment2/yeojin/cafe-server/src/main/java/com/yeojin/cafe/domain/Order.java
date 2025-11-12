package com.yeojin.cafe.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id; // 주문 고유 번호
    private Long menuId; // Menu의 id
    private int quantity;
}
