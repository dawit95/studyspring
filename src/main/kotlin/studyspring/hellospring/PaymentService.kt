package studyspring.hellospring

import com.fasterxml.jackson.databind.ObjectMapper
import java.math.BigDecimal
import java.net.HttpURLConnection
import java.net.URL
import java.time.LocalDateTime
import java.time.ZoneId

class PaymentService {
    fun prepare(orderId: Long, currency: String, foreignCurrencyAmount: BigDecimal): Payment {
        // 환율 가져오기
        val url = URL("https://open.er-api.com/v6/latest/$currency")
        val connection = url.openConnection() as HttpURLConnection

        val response = connection.inputStream.bufferedReader().use { it.readText() }

        val objectMapper = ObjectMapper()
        val data: ExRateData = objectMapper.readValue(response, ExRateData::class.java)
        val exRate: BigDecimal = data.rates["KRW"]!!

        // 금액 계산
        val convertedAmount = foreignCurrencyAmount.multiply(exRate)

        // 유효 시간 설정
        val validUntil = LocalDateTime.now(ZoneId.of("UTC")).plusMinutes(30L)

        return Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil)
    }
}

fun main(args: Array<String>) {
    val paymentService = PaymentService()
    val payment = paymentService.prepare(100L, "USD", BigDecimal(50.7))
    println(payment)
}