package com.yeojin.cafe.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

// 메뉴 조회 시 클라이언트에게 보내는 응답 데이터

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponseDto {
    private Long id; // 메뉴의 번호
    private String name; // 메뉴 이름
    private BigDecimal price; // 메뉴 가격
}
