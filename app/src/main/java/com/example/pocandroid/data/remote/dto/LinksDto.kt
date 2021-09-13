package com.example.pocandroid.data.remote.dto


import com.google.gson.annotations.SerializedName

data class LinksDto(
    @SerializedName("website")
    val website: List<String>?
)