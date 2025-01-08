package studyspring.hellospring

import java.math.BigDecimal

class Client

fun main(args: Array<String>) {
    val objectFactory = ObjectFactory()
    val paymentService = objectFactory.getPaymentService()

    val payment = paymentService.prepare(100L, "USD", BigDecimal(50.7))
    println(payment)
}
