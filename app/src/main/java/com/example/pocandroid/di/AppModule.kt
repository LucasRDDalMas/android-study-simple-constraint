package com.example.pocandroid.di

import com.example.pocandroid.common.Constants
import com.example.pocandroid.data.remote.CoinPaprikaApi
import com.example.pocandroid.data.repository.CoinPaprikaRepositoryImpl
import com.example.pocandroid.domain.repository.CoinPaprikaRepository
import com.example.pocandroid.domain.use_case.get_coins.GetCoinsUseCase
import com.example.pocandroid.domain.use_case.get_exchanges.GetExchangesUseCase
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { providePaprikaApi() }
    single { provideCoinRepository(get()) }
    single { GetCoinsUseCase(get()) }
    single { GetExchangesUseCase(get()) }
}

private fun providePaprikaApi(): CoinPaprikaApi {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinPaprikaApi::class.java)
}

private fun provideCoinRepository(api: CoinPaprikaApi): CoinPaprikaRepository {
    return CoinPaprikaRepositoryImpl(api)
}