package com.vlaskorobogatov.routiner.splash.di

import com.vlaskorobogatov.routiner.splash.component.SplashComponentImpl
import com.vlaskorobogatov.routiner.splashapi.component.SplashComponent
import org.koin.dsl.module

val SplashModule = module {
    
    factory<SplashComponent> { params ->
        SplashComponentImpl(
            componentContext = params.get(),
            storeFactory = get()
        )
    }
}
