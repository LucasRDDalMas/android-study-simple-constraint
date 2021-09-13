package com.example.pocandroid.presentation.get_exchanges

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pocandroid.R
import com.example.pocandroid.common.Resource
import com.example.pocandroid.domain.use_case.get_exchanges.GetExchangesUseCase
import com.example.pocandroid.presentation.coin_list.CoinListActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class ExchangeListActivity: AppCompatActivity() {
    @Inject lateinit var getExchangeUseCase: GetExchangesUseCase
    private lateinit var recyclerView: RecyclerView
    private lateinit var spinner: ProgressBar
    private lateinit var btnExchange: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exchange_list)
Color.Gray
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        spinner = findViewById(R.id.pb_spinner)

        btnExchange = findViewById(R.id.btn_exchange)
        btnExchange.setOnClickListener {
            val intent = Intent(this, CoinListActivity::class.java)
            startActivity(intent)
            finish()
        }

        getExchangeUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    spinner.visibility = View.GONE
                    btnExchange.visibility = View.VISIBLE
                    val adapter = result.data?.let { ExchangeListAdapter(it) }
                    recyclerView.adapter = adapter
                }
                is Resource.Loading -> {
                    spinner.visibility = View.VISIBLE
                }
                is Resource.Error -> {
                    spinner.visibility = View.GONE
                    Toast.makeText(this, "An unexpected error occurred", Toast.LENGTH_LONG).show()
                }
            }
        }.launchIn(lifecycleScope)
    }
}
