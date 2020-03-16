package com.example.covid19app.presentation.fragments.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.covid19app.data.repository.CovidRepository
import com.example.covid19app.data.utils.Result
import com.example.covid19app.model.ResponseAll
import com.example.covid19app.model.ResponseCountries
import kotlinx.coroutines.Dispatchers

class CountriesViewModel(
    private val covidRepository: CovidRepository
) : ViewModel() {

    private val _countriesCases = covidRepository
        .getCountriesCases()
        .asLiveData(Dispatchers.IO + viewModelScope.coroutineContext)

    val countriesCases : LiveData<Result<List<ResponseCountries>>> get() = _countriesCases
}
