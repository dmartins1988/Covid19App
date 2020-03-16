package com.example.covid19app.di

import com.example.covid19app.data.repository.CovidRepository
import org.koin.dsl.module

val RepositoryModule = module {

    factory { CovidRepository(get()) }
}