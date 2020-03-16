package com.example.covid19app

import android.app.Application
import com.example.covid19app.di.NetworkNodule
import com.example.covid19app.di.RepositoryModule
import com.example.covid19app.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CovidApp  : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@CovidApp)
            modules(listOf(NetworkNodule, RepositoryModule, ViewModelModule))
        }

    }

}