package fr.dog.pluginarchitecturesample

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(modifier: Modifier = Modifier, goToDetail: () -> Unit) {
    Text(
        modifier = modifier.clickable { goToDetail() },
        text = "Bonjour"
    )
}