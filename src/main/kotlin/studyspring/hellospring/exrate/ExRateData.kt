package studyspring.hellospring.exrate

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
data class ExRateData(
    @JsonProperty("result") val result: String,
    @JsonProperty("rates") val rates: Map<String, BigDecimal>
)