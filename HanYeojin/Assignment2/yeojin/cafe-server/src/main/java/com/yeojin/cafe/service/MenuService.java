package com.yeojin.cafe.service;

import com.yeojin.cafe.domain.Menu;
import com.yeojin.cafe.dto.MenuResponseDto;
import com.yeojin.cafe.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    // 생성자 주입 = @RequiredArgsConstructor
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // 전체 메뉴 조회
    public List<MenuResponseDto> getAllMenus() {
        List<Menu> menus = menuRepository.findAllMenu();

        // Entity -> DTO 변환
        return menus.stream()
                .map(menu -> new MenuResponseDto(
                        menu.getId(),
                        menu.getName(),
                        menu.getPrice()
                ))
                .collect(Collectors.toList());
    }

}
