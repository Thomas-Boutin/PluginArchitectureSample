package fr.dog.pluginarchitecturesample.animalconfiguration

import androidx.compose.ui.graphics.Color
import fr.dog.detail.DetailConfiguration
import fr.dog.pluginarchitecturesample.R

object DogConfiguration : DetailConfiguration {
    override val nameResource = R.string.dog
    override val imageResource = R.drawable.dog
    override val color = Color.Blue
}