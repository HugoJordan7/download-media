package com.example.downloadmedia

import android.app.Application
import com.example.downloadmedia.di.managerModule
import com.example.downloadmedia.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    managerModule,
                    viewModelModule
                )
            )
        }
    }
}