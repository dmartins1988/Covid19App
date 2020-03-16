package com.example.covid19app.data.remote

import com.example.covid19app.model.ResponseAll
import com.example.covid19app.model.ResponseCountries
import retrofit2.http.GET

interface CovidService {

    @GET("all")
    suspend fun getGlobalCases() : ResponseAll


    @GET("countries")
    suspend fun getCountries() : List<ResponseCountries>

}