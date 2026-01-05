package com.yeojin.cafe.repository;

import com.yeojin.cafe.domain.Menu;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MenuRepository {
    private final Map<Long, Menu> menuStore = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    // 생성자에서 초기 메뉴 데이터 추가
    public MenuRepository() {
        Menu menu1 = new Menu(sequence.getAndIncrement(), "아메리카노", new BigDecimal("4500"));
        Menu menu2 = new Menu(sequence.getAndIncrement(), "바닐라라떼", new BigDecimal("5500"));
        Menu menu3 = new Menu(sequence.getAndIncrement(), "딸기스무디", new BigDecimal("6000"));
        Menu menu4 = new Menu(sequence.getAndIncrement(), "망고스무디", new BigDecimal("6000"));

        menuStore.put(menu1.getId(), menu1);
        menuStore.put(menu2.getId(), menu2);
        menuStore.put(menu3.getId(), menu3);
        menuStore.put(menu4.getId(), menu4);
    }

    // 전체 메뉴 조회
    public List<Menu> findAllMenu() {
        return new ArrayList<>(menuStore.values());
    }

    // menu ID로 조회
    public Optional<Menu> findMenuById(Long id) {
        return Optional.ofNullable(menuStore.get(id));
    }
}
