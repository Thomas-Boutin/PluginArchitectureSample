package fr.dog.pluginarchitecturesample

import fr.dog.pluginarchitecturesample.cat.CatConfiguration
import fr.dog.pluginarchitecturesample.detail.DetailConfiguration
import fr.dog.pluginarchitecturesample.dog.DogConfiguration
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single<DetailConfiguration>(named(Animal.AnimalType.DOG.name)) {
        DogConfiguration
    }
    single<DetailConfiguration>(named(Animal.AnimalType.CAT.name)) {
        CatConfiguration
    }
}