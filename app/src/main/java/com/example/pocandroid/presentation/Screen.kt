package com.example.pocandroid.presentation

sealed class Screen(val route: String) {
    object CoinListScreen: Screen("coin_list_screen")
    object ExchangeListScreen: Screen("exchange_list_screen")
}
