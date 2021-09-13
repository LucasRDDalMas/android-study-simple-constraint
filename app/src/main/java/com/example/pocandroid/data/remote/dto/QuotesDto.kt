package com.example.pocandroid.data.remote.dto


import com.google.gson.annotations.SerializedName

data class QuotesDto(
    @SerializedName("BRL")
    val brL: CurrencyDto,
    @SerializedName("USD")
    val usd: CurrencyDto
)