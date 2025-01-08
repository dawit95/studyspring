package studyspring.hellospring

class ObjectFactory {
    fun getPaymentService(): PaymentService {
        return PaymentService(exRateProvider())
    }

    private fun exRateProvider() = WebAPIExRateProvider()
}