package com.example.pocandroid.data.remote

import com.example.pocandroid.data.remote.dto.CoinDto
import com.example.pocandroid.data.remote.dto.ExchangeDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/exchanges")
    suspend fun getExchanges(@Query("quotes") quotes: String?): List<ExchangeDto>
}