package studyspring.hellospring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ObjectFactory {
    @Bean
    fun getPaymentService(): PaymentService {
        return PaymentService(exRateProvider())
    }

    @Bean
    public fun exRateProvider() = WebAPIExRateProvider()
}