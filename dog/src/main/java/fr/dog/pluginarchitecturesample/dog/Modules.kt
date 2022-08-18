package fr.dog.pluginarchitecturesample.dog

import fr.dog.pluginarchitecturesample.detail.DetailConfiguration
import org.koin.dsl.module

val dogModule = module {
    single<DetailConfiguration> {
        DogConfiguration
    }
}