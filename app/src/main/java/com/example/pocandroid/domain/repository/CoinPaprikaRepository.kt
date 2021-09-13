package com.example.pocandroid.domain.repository

import com.example.pocandroid.domain.model.Coin
import com.example.pocandroid.domain.model.Exchange

interface CoinPaprikaRepository {
    suspend fun getCoins(): List<Coin>
    suspend fun getExchanges(quote: String): List<Exchange>
}