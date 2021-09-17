package com.example.pocandroid.data.repository

import com.example.pocandroid.data.remote.CoinPaprikaApi
import com.example.pocandroid.domain.model.Coin
import com.example.pocandroid.domain.model.Exchange
import com.example.pocandroid.domain.repository.CoinPaprikaRepository

class CoinPaprikaRepositoryImpl(private val coinPaprikaApi: CoinPaprikaApi): CoinPaprikaRepository {
    override suspend fun getCoins(): List<Coin> {
        return coinPaprikaApi.getCoins().map { it.toCoin() }
    }

    override suspend fun getExchanges(quote: String): List<Exchange> {
        return coinPaprikaApi.getExchanges(quote).map { it.toExchange() }
    }
}