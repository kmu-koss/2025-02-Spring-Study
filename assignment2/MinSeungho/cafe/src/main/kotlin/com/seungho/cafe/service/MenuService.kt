package com.seungho.cafe.service

import com.seungho.cafe.dto.MenuResponse
import com.seungho.cafe.repository.MenuRepository
import org.springframework.stereotype.Service

@Service
class MenuService (
    private val menuRepository: MenuRepository
){
    fun getAllMenus(): List<MenuResponse> {
        val menus = menuRepository.findAll()

        return menus.map {
                menu -> MenuResponse.from(menu)
        }
    }
}