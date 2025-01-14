package studyspring.hellospring.exrate

import com.fasterxml.jackson.databind.ObjectMapper
import java.math.BigDecimal
import java.net.HttpURLConnection
import java.net.URL

class WebAPIExRateProvider: ExRateProvider {

    override fun getExRate(currency: String): BigDecimal {
        val url = URL("https://open.er-api.com/v6/latest/$currency")
        val connection = url.openConnection() as HttpURLConnection
        val response = connection.inputStream.bufferedReader().use { it.readText() }

        val objectMapper = ObjectMapper()
        val data: ExRateData = objectMapper.readValue(response, ExRateData::class.java)
        println("web API get EXRate : " + data.rates["KRW"]!!)
        return data.rates["KRW"]!!
    }
}