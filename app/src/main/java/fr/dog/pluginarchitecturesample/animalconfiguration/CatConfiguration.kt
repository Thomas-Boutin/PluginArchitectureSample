package fr.dog.pluginarchitecturesample.animalconfiguration

import androidx.compose.ui.graphics.Color
import fr.dog.detail.DetailConfiguration
import fr.dog.pluginarchitecturesample.R

object CatConfiguration : DetailConfiguration {
    override val nameResource = R.string.cat
    override val imageResource = R.drawable.cat
    override val color: Color = Color.Red
}