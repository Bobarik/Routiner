package com.vlaskorobogatov.routiner.sample.di

import com.vlaskorobogatov.routiner.sample.component.SampleComponent
import com.vlaskorobogatov.routiner.sample.component.SampleComponentImpl
import org.koin.dsl.module

val SampleModule = module {

    single<SampleComponent> { params ->
        SampleComponentImpl(
            componentContext = params.get(),
            storeFactory = get()
        )
    }
}
