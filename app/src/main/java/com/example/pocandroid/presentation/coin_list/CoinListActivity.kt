package com.example.pocandroid.presentation.coin_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pocandroid.R
import com.example.pocandroid.common.Resource
import com.example.pocandroid.domain.model.Coin
import com.example.pocandroid.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class CoinListActivity: AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    @Inject lateinit var getCoinsUseCase: GetCoinsUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_list)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    val adapter = result.data?.let { CoinListAdapter(it) }
                    recyclerView.adapter = adapter
                }
                else -> Log.i("Activity", "SAD")
            }
        }.launchIn(lifecycleScope)
    }
}

