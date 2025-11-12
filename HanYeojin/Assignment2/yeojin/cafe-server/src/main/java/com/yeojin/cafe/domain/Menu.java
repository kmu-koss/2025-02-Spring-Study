package com.yeojin.cafe.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private Long id; // 메뉴의 고유 번호
    private String name; // 메뉴 이름
    private BigDecimal price; // 가격

}
