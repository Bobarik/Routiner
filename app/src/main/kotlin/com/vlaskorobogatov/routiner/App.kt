package com.vlaskorobogatov.routiner

import android.app.Application
import com.vlaskorobogatov.routiner.onboarding.di.OnboardingModule
import com.vlaskorobogatov.routiner.root.di.RootModule
import com.vlaskorobogatov.routiner.splash.di.SplashModule
import com.vlaskorobogatov.routiner.start.di.StartModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                AppModule,
                RootModule,
                SplashModule,
                StartModule,
                OnboardingModule
            )
        }
    }
}
