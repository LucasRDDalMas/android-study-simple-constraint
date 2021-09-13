package com.example.pocandroid.presentation.get_exchanges

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.recyclerview.widget.RecyclerView
import com.example.pocandroid.R
import com.example.pocandroid.domain.model.Exchange

class ExchangeListAdapter(private val exchanges: List<Exchange>) :
    RecyclerView.Adapter<ExchangeListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mExchangeName: TextView = view.findViewById(R.id.tv_coin_name)
        val mStatus: TextView = view.findViewById(R.id.tv_coin_status)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.coin_list_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.mExchangeName.text = "${exchanges[position].rank}. ${exchanges[position].name}"
        viewHolder.mStatus.text = if (exchanges[position].active) "Active" else "Inactive"
        val color: Color = if (exchanges[position].active) Color.Green else Color.Red
        viewHolder.mStatus.setTextColor(color.toArgb())
    }

    override fun getItemCount() = exchanges.size
}