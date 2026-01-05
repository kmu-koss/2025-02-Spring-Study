package koss.cafe_kiosk.domain.impl

import koss.cafe_kiosk.domain.Beverage
import koss.cafe_kiosk.domain.Blendable

class Smoothie : Beverage, Blendable {
    override val name  = "스무디"

    override fun blendFruits() {
        println("과일 얼음 가가갉")
    }

    override fun make() {
        blendFruits()
        println("완성~")
    }
}