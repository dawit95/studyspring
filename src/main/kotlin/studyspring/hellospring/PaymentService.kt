package studyspring.hellospring

import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.ZoneId

class PaymentService {
    private val exRateProvider: WebAPIExRateProvider = WebAPIExRateProvider()

    fun prepare(orderId: Long, currency: String, foreignCurrencyAmount: BigDecimal): Payment {
        val exRate: BigDecimal = exRateProvider.getExchageRate(currency)
        val convertedAmount = foreignCurrencyAmount.multiply(exRate)
        val validUntil = LocalDateTime.now(ZoneId.of("UTC")).plusMinutes(30L)

         return Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil)
    }
}
