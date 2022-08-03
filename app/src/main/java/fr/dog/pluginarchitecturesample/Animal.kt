package fr.dog.pluginarchitecturesample

@JvmInline
value class AnimalName(val value: String)

class Animal(
    val name: AnimalName,
    val type: AnimalType
) {
    fun format() = "${name.value} (${type.name})"

    enum class AnimalType {
       DOG,
       CAT
   }
}
