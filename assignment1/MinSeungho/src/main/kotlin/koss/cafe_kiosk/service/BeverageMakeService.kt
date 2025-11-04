package koss.cafe_kiosk.service

import koss.cafe_kiosk.domain.Beverage
import org.springframework.stereotype.Service

@Service
class BeverageMakeService {
    fun prepareBeverage(beverage: Beverage) {
        println("${beverage.name} 제작 시작")
        beverage.make()
        println("${beverage.name} 제작 완료")
    }
}