package koss.cafe_kiosk.service.factory

import jakarta.annotation.PostConstruct
import koss.cafe_kiosk.domain.Beverage
import koss.cafe_kiosk.domain.impl.Americano
import koss.cafe_kiosk.domain.impl.Latte
import koss.cafe_kiosk.domain.impl.Smoothie
import org.springframework.stereotype.Component

@Component
class BeverageFactory {
    private val beverageCreators = mutableMapOf<String, () -> Beverage>()
    @PostConstruct
    fun init() {
        registerBeverage("아메리카노") { Americano() }
        registerBeverage("라떼") { Latte() }
        registerBeverage("딸기 스무디") { Smoothie() }
    }

    fun registerBeverage(name: String, creator: () -> Beverage) {
        beverageCreators[name.uppercase()] = creator
    }

    fun createBeverage(name: String): Beverage {
        val creator = beverageCreators[name.uppercase()]
            ?: throw IllegalArgumentException("[$name] 메뉴를 찾을 수 없습니다.")
        return creator()
    }
}
