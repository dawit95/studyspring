package studyspring.hellospring

import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.ZoneId

abstract class PaymentService {
    fun prepare(orderId: Long, currency: String, foreignCurrencyAmount: BigDecimal): Payment {
        val exRate: BigDecimal = getExchageRate(currency)
        val convertedAmount = foreignCurrencyAmount.multiply(exRate)
        val validUntil = LocalDateTime.now(ZoneId.of("UTC")).plusMinutes(30L)

        return Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil)
    }

    abstract fun getExchageRate(currency: String): BigDecimal
}
