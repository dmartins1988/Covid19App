package com.example.covid19app.presentation.fragments.global

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.covid19app.R
import com.example.covid19app.data.utils.Result
import com.example.covid19app.extensions.gone
import com.example.covid19app.extensions.visible
import com.example.covid19app.model.ResponseAll
import com.example.covid19app.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.global_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class GlobalFragment : BaseFragment(){

    private val viewModel: GlobalViewModel by viewModel()

    companion object {
        fun newInstance() =
            GlobalFragment()
    }

    override fun layoutId(): Int = R.layout.global_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeGlobalCases()
    }

    override fun onResume() {
        super.onResume()
        observeGlobalCases()
    }

    private fun observeGlobalCases() {
        viewModel.allCases.observe(viewLifecycleOwner, Observer { response ->
            when(response) {
                is Result.Loading -> {
                    changeVisibility(true)
                    progress_bar.visible()
                }
                is Result.Success -> {
                    changeVisibility(false)
                    progress_bar.gone()
                    empty_tv.gone()
                    setItemsOnView(response)
                }
                is Result.Error -> {
                    changeVisibility(true)
                    empty_tv.text = "No Result"
                    empty_tv.visible()
                    progress_bar.gone()
                }
            }
        })
    }

    private fun setItemsOnView(response: Result.Success<ResponseAll>) {
        global_cases_card_view.setTitle("Global Cases")
        global_cases_card_view.setSubtitle(response.data.cases.toString(), R.color.colorYellowText)
        global_recovers_card_view.setTitle("Recovers")
        global_recovers_card_view.setSubtitle(response.data.recovered.toString(), R.color.colorGreenText)
        global_deaths_card_view.setTitle("Deaths")
        global_deaths_card_view.setSubtitle(response.data.deaths.toString(), R.color.colorRedText)
    }

    private fun changeVisibility(visibility: Boolean) {
        if (visibility) {
            global_cases_card_view.gone()
            global_deaths_card_view.gone()
            global_recovers_card_view.gone()
        } else {
            global_cases_card_view.visible()
            global_deaths_card_view.visible()
            global_recovers_card_view.visible()
        }
    }

}
