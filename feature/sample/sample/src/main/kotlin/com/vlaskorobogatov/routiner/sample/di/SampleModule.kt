package com.vlaskorobogatov.routiner.sample.di

import com.vlaskorobogatov.routiner.sample.component.SampleComponentImpl
import com.vlaskorobogatov.routiner.sampleapi.component.SampleComponent
import org.koin.dsl.module

val SampleModule = module {

    single<SampleComponent> { params ->
        SampleComponentImpl(
            componentContext = params.get(),
            storeFactory = get()
        )
    }
}
