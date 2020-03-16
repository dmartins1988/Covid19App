package com.example.covid19app.model


import com.google.gson.annotations.SerializedName

data class ResponseAll(
    @SerializedName("cases")
    val cases: Int,
    @SerializedName("deaths")
    val deaths: Int,
    @SerializedName("recovered")
    val recovered: Int
)