package com.example.covid19app.di

import com.example.covid19app.data.remote.CovidService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val NetworkNodule = module {

    factory { OkHttpClient.Builder().build() }

    single { Retrofit.Builder()
        .client(get())
        .baseUrl("https://corona.lmao.ninja/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
    }

    factory { get<Retrofit>().create(CovidService::class.java) }

}