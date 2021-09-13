package com.example.pocandroid.data.remote.dto


import com.google.gson.annotations.SerializedName

data class CurrencyDto(
    @SerializedName("adjusted_volume_24h")
    val adjustedVolume24h: Double,
    @SerializedName("adjusted_volume_30d")
    val adjustedVolume30d: Double,
    @SerializedName("adjusted_volume_7d")
    val adjustedVolume7d: Double,
    @SerializedName("reported_volume_24h")
    val reportedVolume24h: Double,
    @SerializedName("reported_volume_30d")
    val reportedVolume30d: Double,
    @SerializedName("reported_volume_7d")
    val reportedVolume7d: Double
)