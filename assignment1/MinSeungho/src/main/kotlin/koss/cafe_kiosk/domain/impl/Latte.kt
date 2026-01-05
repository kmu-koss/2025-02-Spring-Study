package koss.cafe_kiosk.domain.impl

import koss.cafe_kiosk.domain.Beverage
import koss.cafe_kiosk.domain.Grindable

class Latte : Beverage, Grindable {

    override val name: String = "라떼"

    override fun grindBeans() {
        println("원두를 가가갉.")
    }

    override fun make() {
        grindBeans()

        val milk = steamMilk()

        println("에스프레소와 $milk 를 섞습니다.")
        println("$name 완성!")
    }

    private fun steamMilk(): String {
        println("우유를 데우고 거품을 냅니다")
        return "스팀 밀크"
    }
}