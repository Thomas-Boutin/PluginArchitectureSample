package fr.dog.pluginarchitecturesample.cat

import androidx.compose.ui.graphics.Color
import fr.dog.detail.DetailConfiguration

object CatConfiguration : DetailConfiguration {
    override val nameResource = R.string.cat
    override val imageResource = R.drawable.cat
    override val color: Color = Color.Red
}