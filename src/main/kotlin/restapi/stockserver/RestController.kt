package restapi.stockserver

import io.netty.util.internal.ThreadLocalRandom
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import restapi.stockserver.data.classes.StockPrice
import java.time.Duration
import java.time.LocalDateTime

@RestController
class RestController(){
    @GetMapping(value = ["/stock/{symbol}"],
            produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun prices(@PathVariable symbol: String): Flux<StockPrice> {
        return Flux
                .interval(Duration.ofSeconds(1))
                .map { StockPrice(symbol, randomStockPrice(), LocalDateTime.now()) }
    }

    private fun randomStockPrice(): Double {
        return ThreadLocalRandom.current().nextDouble(100.0)
    }
}
