package com.example.pocandroid.domain.model

data class Exchange(
    val id: String,
    val name: String,
    val active: Boolean,
    val rank: Int,
    val website: String?
)
