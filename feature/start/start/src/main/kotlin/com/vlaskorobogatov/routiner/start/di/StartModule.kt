package com.vlaskorobogatov.routiner.start.di

import com.vlaskorobogatov.routiner.start.component.StartComponentImpl
import com.vlaskorobogatov.routiner.startapi.component.StartComponent
import org.koin.dsl.module

val StartModule = module {
    factory<StartComponent> { params ->
        StartComponentImpl(
            componentContext = params.get(),
            storeFactory = get(),
            onProcess = params.get()
        )
    }
}
