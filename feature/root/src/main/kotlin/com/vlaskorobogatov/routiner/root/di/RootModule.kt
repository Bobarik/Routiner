package com.vlaskorobogatov.routiner.root.di

import com.vlaskorobogatov.routiner.root.component.RootComponentImpl
import com.vlaskorobogatov.routiner.root.component.RootComponent
import org.koin.dsl.module

val RootModule = module {

    factory<RootComponent> { params ->
        RootComponentImpl(
            componentContext = params.get(),
            storeFactory = get()
        )
    }
}
