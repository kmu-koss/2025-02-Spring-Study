package com.seungho.cafe.dto

import com.seungho.cafe.domain.Menu

// 메뉴 조회 응답
data class MenuResponse(
    val id: Long,
    val name: String,
    val price: Long
) {
    companion object {
        fun from(menu: Menu): MenuResponse {
            return MenuResponse(
                id = menu.id,
                name = menu.name,
                price = menu.price
            )
        }
    }
}
