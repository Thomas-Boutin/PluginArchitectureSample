package fr.dog.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    detailConfiguration: DetailConfiguration = DefaultDetailConfiguration
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = modifier.padding(10.dp),
            text = stringResource(detailConfiguration.nameResource),
            textAlign = TextAlign.Center,
            color = detailConfiguration.color
        )
        Image(
            painter = painterResource(detailConfiguration.imageResource),
            contentDescription = stringResource(R.string.animal_image)
        )
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen()
}