package com.example.restapiproject.ui.networkCountries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.restapiproject.R
import com.example.restapiproject.databinding.FragmentCountriesBinding
import com.example.restapiproject.model.ResultItem
import kotlinx.android.synthetic.main.item_each_result.view.*
import java.util.ArrayList

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var models: MutableList<ResultItem> = mutableListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun populateModel(model: ResultItem) {
            itemView.tvCountry.text = model.country
            itemView.countCases.text = "${model.cases.toString()} |"
            itemView.countDeath.text = "${model.deaths.toString()} |"
            itemView.countRecovered.text = "${model.recovered.toString()} |"

            itemView.casesTodayCount.text = "Today: ${model.todayCases.toString()}"
            itemView.deathsTodayCount.text = "Today: ${model.todayDeaths.toString()}"
            itemView.criticalCount.text = "Critical: ${model.critical.toString()}"

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_each_result, parent, false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(models.get(position))
    }

    override fun getItemCount(): Int = models.size

}