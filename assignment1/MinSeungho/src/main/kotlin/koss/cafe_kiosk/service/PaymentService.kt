package koss.cafe_kiosk.service

import org.springframework.stereotype.Service

@Service
class PaymentService {
    fun processPayment(amount: Double) : Boolean {
        println("결제를 시도")
        println("결제 성공")
        return true
    }
}