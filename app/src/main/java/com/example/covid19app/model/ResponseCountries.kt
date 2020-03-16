package com.example.covid19app.model


import com.google.gson.annotations.SerializedName

data class ResponseCountries(
    @SerializedName("cases")
    val cases: Int,
    @SerializedName("country")
    val country: String,
    @SerializedName("critical")
    val critical: Int,
    @SerializedName("deaths")
    val deaths: Int,
    @SerializedName("recovered")
    val recovered: Int,
    @SerializedName("todayCases")
    val todayCases: Int,
    @SerializedName("todayDeaths")
    val todayDeaths: Int
)