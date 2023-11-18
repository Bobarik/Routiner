package com.vlaskorobogatov.routiner

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import org.koin.dsl.module

val AppModule = module {
    single<StoreFactory> {DefaultStoreFactory()}
}
