package com.example.pocandroid.presentation.coin_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.recyclerview.widget.RecyclerView
import com.example.pocandroid.R
import com.example.pocandroid.domain.model.Coin

class CoinListAdapter(private val coins: List<Coin>) :
    RecyclerView.Adapter<CoinListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mCoinName: TextView = view.findViewById(R.id.tv_coin_name)
        val mStatus: TextView = view.findViewById(R.id.tv_coin_status)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.coin_list_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.mCoinName.text = "${coins[position].rank}. ${coins[position].name} (${coins[position].symbol})"
        viewHolder.mStatus.text = if (coins[position].isActive) "Active" else "Inactive"
        val color: Color = if (coins[position].isActive) Color.Green else Color.Red
        viewHolder.mStatus.setTextColor(color.toArgb())
    }

    override fun getItemCount() = coins.size
}