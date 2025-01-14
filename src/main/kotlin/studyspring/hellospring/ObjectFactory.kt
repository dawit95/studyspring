package studyspring.hellospring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import studyspring.hellospring.payment.PaymentService
import studyspring.hellospring.exrate.CachedExRateProvider
import studyspring.hellospring.exrate.WebAPIExRateProvider

@Configuration
class ObjectFactory {
    @Bean
    fun getPaymentService(): PaymentService {
        return PaymentService(cachedExRateProvider())
    }

    @Bean
    fun cachedExRateProvider() = CachedExRateProvider(exRateProvider())

    @Bean
    fun exRateProvider() = WebAPIExRateProvider()
}