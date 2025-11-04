package koss.cafe_kiosk.controller

import koss.cafe_kiosk.controller.dto.OrderRequest
import koss.cafe_kiosk.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kiosk")
class KioskController(
    // Kiosk는 이제 OrderService에만 의존한다.
    private val orderService: OrderService
) {

    @PostMapping("/order")
    fun order(@RequestBody request: OrderRequest): ResponseEntity<String> {
        return try {
            val result = orderService.placeOrder(request.beverageName)
            ResponseEntity.ok(result)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }
}