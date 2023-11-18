package com.vlaskorobogatov.routiner

import android.app.Application
import com.vlaskorobogatov.routiner.root.di.RootModule
import com.vlaskorobogatov.routiner.sample.di.SampleModule
import com.vlaskorobogatov.routiner.splash.di.SplashModule
import org.koin.dsl.koinApplication

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        koinApplication {
            RootModule
            SampleModule
            SplashModule
        }
    }
}
