package fr.dog.pluginarchitecturesample.dog

import androidx.compose.ui.graphics.Color
import fr.dog.detail.DetailConfiguration

object DogConfiguration : DetailConfiguration {
    override val nameResource = R.string.dog
    override val imageResource = R.drawable.dog
    override val color = Color.Blue
}