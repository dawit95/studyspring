package studyspring.hellospring

import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.ZoneId

@Component
class PaymentService {
    private val exRateProvider: ExRateProvider

    constructor(exRateProvider: ExRateProvider) {
        this.exRateProvider = exRateProvider
    }

    fun prepare(orderId: Long, currency: String, foreignCurrencyAmount: BigDecimal): Payment {
        val exRate: BigDecimal = exRateProvider.getExRate(currency)
        val convertedAmount = foreignCurrencyAmount.multiply(exRate)
        val validUntil = LocalDateTime.now(ZoneId.of("UTC")).plusMinutes(30L)

         return Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil)
    }
}
