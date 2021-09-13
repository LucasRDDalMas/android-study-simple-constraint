package com.example.pocandroid.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.example.pocandroid.domain.model.Coin

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
) {
    fun toCoin(): Coin {
        return Coin(
            id = id,
            isActive = isActive,
            name = name,
            rank = rank,
            symbol = symbol
        )
    }
}