package studyspring.hellospring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan
class ObjectFactory {
    /*@Bean
    fun getPaymentService(): PaymentService {
        return PaymentService(exRateProvider())
    }

    @Bean
    public fun exRateProvider() = WebAPIExRateProvider()*/
}