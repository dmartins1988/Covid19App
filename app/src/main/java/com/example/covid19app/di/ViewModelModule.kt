package com.example.covid19app.di

import com.example.covid19app.presentation.fragments.countries.CountriesViewModel
import com.example.covid19app.presentation.fragments.global.GlobalViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {

    viewModel { GlobalViewModel(get()) }

    viewModel { CountriesViewModel(get()) }

}