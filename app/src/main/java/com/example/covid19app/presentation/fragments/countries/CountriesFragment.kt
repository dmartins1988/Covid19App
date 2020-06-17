package com.example.covid19app.presentation.fragments.countries

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.covid19app.R
import com.example.covid19app.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.countries_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel
import com.example.covid19app.data.utils.Result
import com.example.covid19app.extensions.gone
import com.example.covid19app.extensions.visible

class CountriesFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {

    private val viewModel: CountriesViewModel by viewModel()

    private lateinit var countriesAdapter: CountriesAdapter

    companion object {
        fun newInstance() =
            CountriesFragment()
    }

    override fun layoutId(): Int = R.layout.countries_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRecyclerView()
        refreshLayout()
        fetchData()
    }

    private fun refreshLayout() {
        swipe_to_refresh.setOnRefreshListener(this)
        fetchData()
    }

    private fun configureRecyclerView() {
        countriesAdapter = CountriesAdapter()
        recycler_view.apply {
            setHasFixedSize(true)
            adapter = countriesAdapter
        }
    }

    private fun fetchData() {
        viewModel.countriesCases.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Result.Loading -> {
                    progressIndicator.show()
                    recycler_view.gone()
                }
                is Result.Success -> {
                    progressIndicator.hide()
                    if (response.data.isNotEmpty()) {
                        recycler_view.visible()
                        countriesAdapter.submitList(response.data)
                    } else {
                        recycler_view.gone()
                    }
                }
                is Result.Error -> {
                    progressIndicator.hide()
                    recycler_view.gone()
                }
            }
        })
    }

    override fun onRefresh() {
        swipe_to_refresh.isRefreshing = false
        fetchData()
    }

}
