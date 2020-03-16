package com.example.covid19app.presentation.fragments.countries

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19app.R
import com.example.covid19app.model.ResponseCountries

class CountriesAdapter: ListAdapter<ResponseCountries, RecyclerView.ViewHolder>(CountriesCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.country_item_card_view, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as ListViewHolder).bind(item)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var countriesName : TextView = itemView.findViewById(R.id.country_name_tv)
        private var numberDeaths: TextView = itemView.findViewById(R.id.deaths_tv)
        private var numberCases: TextView = itemView.findViewById(R.id.cases_tv)
        private var numberRecovered: TextView = itemView.findViewById(R.id.recovers_tv)
        private var numberCritical: TextView = itemView.findViewById(R.id.critical_tv)
        private var numberTodayCases: TextView = itemView.findViewById(R.id.today_cases_tv)
        private var numberTodayDeaths: TextView = itemView.findViewById(R.id.today_deaths_tv)

        fun bind(response: ResponseCountries) {
            countriesName.text = response.country
            numberDeaths.text = response.deaths.toString()
            numberCases.text = response.cases.toString()
            numberRecovered.text = response.recovered.toString()
            numberCritical.text = response.critical.toString()
            numberTodayCases.text = response.todayCases.toString()
            numberTodayDeaths.text = response.todayDeaths.toString()
        }
    }


    class CountriesCallback : DiffUtil.ItemCallback<ResponseCountries>() {
        override fun areItemsTheSame(
            oldItem: ResponseCountries,
            newItem: ResponseCountries
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: ResponseCountries,
            newItem: ResponseCountries
        ): Boolean = oldItem == newItem

    }

}