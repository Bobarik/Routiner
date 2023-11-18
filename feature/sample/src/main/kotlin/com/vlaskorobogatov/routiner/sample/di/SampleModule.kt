package com.vlaskorobogatov.routiner.sample.di

import com.vlaskorobogatov.routiner.sample.component.SampleComponentImpl
import com.vlaskorobogatov.routiner.sample.component.SampleComponent
import org.koin.dsl.module

val SampleModule = module {

    factory<SampleComponent> { params ->
        SampleComponentImpl(
            componentContext = params.get(),
            storeFactory = get()
        )
    }
}
