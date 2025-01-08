package studyspring.hellospring

import java.math.BigDecimal

class SimpleExRateProvider {
    fun getExchageRate(currency: String): BigDecimal {
        return if(currency.equals("USD",true)){
            BigDecimal.valueOf(1000);
        }else throw IllegalArgumentException("지원되지 않는 통화 입니다.")
    }
}