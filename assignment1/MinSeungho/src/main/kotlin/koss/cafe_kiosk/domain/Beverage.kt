package koss.cafe_kiosk.domain

interface Beverage {
    val name: String
    fun make() // 음료 제작 공통 메서드
}