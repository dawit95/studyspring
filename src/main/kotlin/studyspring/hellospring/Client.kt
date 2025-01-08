package studyspring.hellospring

import java.math.BigDecimal

class Client

fun main(args: Array<String>) {
//    val paymentService = WebAPIExRatePaymentService()
    val paymentService = SimpleExRatePaymentService()
    val payment = paymentService.prepare(100L, "USD", BigDecimal(50.7))
    println(payment)
}
