package com.example.restapiproject.fragments.countries

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.restapiproject.R
import com.example.restapiproject.databinding.FragmentCountriesBinding
import com.example.restapiproject.model.ResultItem
import com.example.restapiproject.retrofit.ApiClient
import com.example.restapiproject.ui.networkCountries.Adapter
import com.example.restapiproject.ui.networkCountries.NetworkHelper
import com.example.restapiproject.ui.networkCountries.NetworkListener

class CountriesFragment : Fragment(R.layout.fragment_countries), NetworkListener {

    lateinit var networkHelper: NetworkHelper
    private val adapter = Adapter()
    private val adapterCopy = adapter
    private lateinit var binding: FragmentCountriesBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCountriesBinding.bind(view)
        binding.rvItem.adapter = adapter
        binding.rvItem.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        networkHelper = NetworkHelper(ApiClient.getClient())
        setData()
        countriesSearch()

    }

    //Search function

    private fun countriesSearch() {
        binding.etSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                search(newText)
                return true
            }
        })
    }

    private fun setData() {
        networkHelper.getClasses(this)
    }

    override fun onCountriesResultResponses(models: MutableList<ResultItem>?) {
        adapter.models = models!!
    }

    override fun onCountriesResultFailure(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private var searchResult: ArrayList<ResultItem> = arrayListOf()

    private fun search(text: String?) {

        searchResult = arrayListOf()

        text?.let {
            adapter.models.forEach { result ->
                if (result.country.contains(text, true)) {
                    searchResult.add(result)
                }
            }
            updateRecyclerView()

            if (searchResult.isEmpty()) {
                Toast.makeText(requireContext(), "Not found", Toast.LENGTH_SHORT).show()
            }
            updateRecyclerView()
        }
    }

    private fun updateRecyclerView() {
        binding.rvItem.apply {
            adapterCopy.models = searchResult
            adapter?.notifyDataSetChanged()
        }
    }

    // this is fragment
}
