package koss.cafe_kiosk.service
import koss.cafe_kiosk.service.factory.BeverageFactory

class OrderService(
    private val beverageMakeService: BeverageMakeService,
    private val paymentService: PaymentService,
    private val beverageFactory: BeverageFactory
) {
    fun placeOrder(beverageName: String) : String {
        val beverage = beverageFactory.createBeverage(beverageName)
        val price = 5000.0
        if (!paymentService.processPayment(price)) {
            return "결제에 실패했습니다."
        }

        beverageMakeService.prepareBeverage(beverage)

        return "${beverage.name} 주문이 완료되었습니다."

    }
}