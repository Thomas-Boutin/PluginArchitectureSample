package fr.dog.pluginarchitecturesample.dog

import fr.dog.pluginarchitecturesample.data.Animal
import fr.dog.pluginarchitecturesample.detail.DetailConfiguration
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dogModule = module {
    single<DetailConfiguration>(named(Animal.AnimalType.DOG.name)) {
        DogConfiguration
    }
}