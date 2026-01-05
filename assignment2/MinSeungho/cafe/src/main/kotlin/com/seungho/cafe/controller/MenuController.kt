package com.seungho.cafe.controller

import com.seungho.cafe.dto.MenuResponse
import com.seungho.cafe.service.MenuService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/menus")
class MenuController (
    private val menuService: MenuService
){
    @GetMapping
    fun getAllMenus() : ResponseEntity<List<MenuResponse>> {
        val menus = menuService.getAllMenus()
        return ResponseEntity.ok(menus)
    }
}