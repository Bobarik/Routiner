package com.vlaskorobogatov.routiner

import android.app.Application
import com.vlaskorobogatov.routiner.sample.di.SampleModule
import org.koin.dsl.koinApplication

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        koinApplication {
            SampleModule
        }
    }
}
