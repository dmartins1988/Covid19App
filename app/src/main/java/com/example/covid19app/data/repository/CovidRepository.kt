package com.example.covid19app.data.repository

import com.example.covid19app.data.remote.CovidService
import com.example.covid19app.data.utils.Result
import com.example.covid19app.data.utils.safeApiCall
import kotlinx.coroutines.flow.flow

class CovidRepository(
    private val covidService: CovidService
) {

    fun getAllCases() = flow {
        emit(Result.Loading)
        emit(
            safeApiCall { covidService.getGlobalCases() }
        )
    }

    fun getCountriesCases() = flow {
        emit(Result.Loading)
        emit(
            safeApiCall { covidService.getCountries() }
        )
    }
}