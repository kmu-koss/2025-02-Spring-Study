package koss.cafe_kiosk.domain.impl

import koss.cafe_kiosk.domain.Beverage
import koss.cafe_kiosk.domain.Grindable

class Americano : Beverage, Grindable {
    override val name = "Americano"

    override fun grindBeans() {
        println("Americano grind")
    }

    override fun make() {
        grindBeans()
        println("Americano make done")
    }
}