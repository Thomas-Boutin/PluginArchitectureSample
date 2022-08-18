package fr.dog.pluginarchitecturesample.cat

import fr.dog.pluginarchitecturesample.detail.DetailConfiguration
import org.koin.dsl.module

val catModule = module {
    single<DetailConfiguration> {
        CatConfiguration
    }
}