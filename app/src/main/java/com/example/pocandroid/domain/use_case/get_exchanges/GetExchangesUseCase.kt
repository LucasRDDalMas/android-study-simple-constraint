package com.example.pocandroid.domain.use_case.get_exchanges

import com.example.pocandroid.common.Resource
import com.example.pocandroid.domain.model.Exchange
import com.example.pocandroid.domain.repository.CoinPaprikaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetExchangesUseCase @Inject constructor(private val coinPaprikaRepository: CoinPaprikaRepository) {
    operator fun invoke(): Flow<Resource<List<Exchange>>> = flow {
        try {
            emit(Resource.Loading<List<Exchange>>())
            var exchanges = coinPaprikaRepository.getExchanges("BRL")
            exchanges = exchanges.filter { it.rank != 0 }.sortedBy { it.rank }
            emit(Resource.Success<List<Exchange>>(exchanges))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Exchange>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Exchange>>("Couldn't reach server. Check your internet connection."))
        }
    }
}