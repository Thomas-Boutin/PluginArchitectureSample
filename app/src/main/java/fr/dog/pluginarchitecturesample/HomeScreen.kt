package fr.dog.pluginarchitecturesample

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val animals = listOf(
    Animal(AnimalName("Rex"), Animal.AnimalType.DOG),
    Animal(AnimalName("Garfield"), Animal.AnimalType.CAT)
)

@Composable
fun HomeScreen(modifier: Modifier = Modifier, goToDetail: (Animal.AnimalType) -> Unit) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(animals) { animal ->
            Card(
                modifier = modifier
                    .height(100.dp)
                    .width(200.dp)
                    .padding(top = 10.dp)
                    .clickable { goToDetail(animal.type) },
            ) {
                Text(
                    modifier = modifier
                        .wrapContentHeight(),
                    text = animal.format(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(goToDetail = {})
}