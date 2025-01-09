package studyspring.hellospring

import java.math.BigDecimal
import java.time.LocalDateTime

class CachedExRateProvider(exRateProvider: ExRateProvider) : ExRateProvider {
    private val target: ExRateProvider = exRateProvider

    private var cachedExRate: BigDecimal? = null
    private var cacheExpiryTime: LocalDateTime? = null

    override fun getExRate(currency: String): BigDecimal {
        if(cachedExRate == null || (cacheExpiryTime != null && cacheExpiryTime!!.isBefore(LocalDateTime.now()))) {
            cachedExRate = target.getExRate(currency)
            cacheExpiryTime = LocalDateTime.now().plusSeconds(3)
            println("Cached exrate for $currency Update~!")
        }
        return cachedExRate!!
    }
}