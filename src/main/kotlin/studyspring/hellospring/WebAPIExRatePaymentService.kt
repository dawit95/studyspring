package studyspring.hellospring

import com.fasterxml.jackson.databind.ObjectMapper
import java.math.BigDecimal
import java.net.HttpURLConnection
import java.net.URL

class WebAPIExRatePaymentService : PaymentService() {
    override fun getExchageRate(currency: String): BigDecimal {
        val url = URL("https://open.er-api.com/v6/latest/$currency")
        val connection = url.openConnection() as HttpURLConnection
        val response = connection.inputStream.bufferedReader().use { it.readText() }

        val objectMapper = ObjectMapper()
        val data: ExRateData = objectMapper.readValue(response, ExRateData::class.java)
        val exRate: BigDecimal = data.rates["KRW"]!!
        return exRate
    }
}