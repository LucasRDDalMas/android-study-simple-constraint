package com.example.pocandroid

import android.app.Application
import com.example.pocandroid.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // declare used Android context
            androidContext(this@MainApplication)
            // declare modules
            modules(appModule)
        }
    }
}