package fr.dog.pluginarchitecturesample

import org.junit.Assert.assertEquals
import org.junit.Test

class AnimalTest {

    @Test
    fun `Should format the Animal's name`() {
        val animal = Animal(AnimalName("Bob"), Animal.AnimalType.DOG)

        assertEquals("Bob (DOG)", animal.format())
    }
}