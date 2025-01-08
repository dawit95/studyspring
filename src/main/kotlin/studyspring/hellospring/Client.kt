package studyspring.hellospring

import java.math.BigDecimal

class Client

fun main(args: Array<String>) {
    val payment = PaymentService().prepare(100L, "USD", BigDecimal(50.7))
    println(payment)
}
