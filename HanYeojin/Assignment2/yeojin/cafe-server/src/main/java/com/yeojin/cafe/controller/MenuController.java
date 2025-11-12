package com.yeojin.cafe.controller;

import com.yeojin.cafe.dto.MenuResponseDto;
import com.yeojin.cafe.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/menus")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    // 전체 메뉴 조회 - GET /api/menus
    @GetMapping
    public List<MenuResponseDto> getAllMenus() {
        return menuService.getAllMenus();
    }
}
