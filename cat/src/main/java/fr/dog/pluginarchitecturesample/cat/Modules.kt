package fr.dog.pluginarchitecturesample.cat

import fr.dog.pluginarchitecturesample.data.Animal
import fr.dog.pluginarchitecturesample.detail.DetailConfiguration
import org.koin.core.qualifier.named
import org.koin.dsl.module

val catModule = module {
    single<DetailConfiguration>(named(Animal.AnimalType.CAT.name)) {
        CatConfiguration
    }
}