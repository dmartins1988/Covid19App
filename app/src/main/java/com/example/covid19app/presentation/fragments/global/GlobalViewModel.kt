package com.example.covid19app.presentation.fragments.global

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.covid19app.data.repository.CovidRepository
import com.example.covid19app.data.utils.Result
import com.example.covid19app.model.ResponseAll
import kotlinx.coroutines.Dispatchers

class GlobalViewModel(
    covidRepository: CovidRepository
) : ViewModel() {

    private val _allCases = covidRepository
        .getAllCases()
        .asLiveData(Dispatchers.IO)

    val allCases : LiveData<Result<ResponseAll>> get() = _allCases

}
