package com.seungho.cafe.dto

// 메뉴 주문 요청
data class OrderRequest(
    val menuId: Long,
    val quantity: Int
)
