package com.example.pocandroid.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.example.pocandroid.domain.model.Exchange

data class ExchangeDto(
    val active: Boolean,
    @SerializedName("adjusted_rank")
    val adjustedRank: Int,
    @SerializedName("api_status")
    val apiStatus: Boolean,
    @SerializedName("confidence_score")
    val confidenceScore: Double,
    val currencies: Int,
    val description: String,
    val fiats: List<Any>,
    val id: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    val links: LinksDto?,
    val markets: Int,
    val marketsDataFetched: Boolean,
    val message: Any,
    val name: String,
    val quotes: QuotesDto,
    @SerializedName("reported_rank")
    val reportedRank: Int,
    @SerializedName("website_status")
    val websiteStatus: Boolean
) {
    fun toExchange(): Exchange {
        return Exchange(
            id = id,
            name = name,
            active = active,
            rank = reportedRank,
            website = links?.website?.get(0)
        )
    }
}