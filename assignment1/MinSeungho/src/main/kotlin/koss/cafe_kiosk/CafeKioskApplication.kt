package koss.cafe_kiosk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CafeKioskApplication

fun main(args: Array<String>) {
	runApplication<CafeKioskApplication>(*args)
}
