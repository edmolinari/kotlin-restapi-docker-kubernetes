package restapi.stockserver.data.classes

import java.time.LocalDateTime

data class StockPrice(
        val symbol: String,
        val randomStockPrice: Double,
        val time: LocalDateTime
)
