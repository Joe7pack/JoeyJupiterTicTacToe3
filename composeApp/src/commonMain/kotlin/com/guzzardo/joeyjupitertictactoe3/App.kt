package com.guzzardo.joeyjupitertictactoe3

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import joeyjupitertictactoe3.composeapp.generated.resources.Res
import joeyjupitertictactoe3.composeapp.generated.resources.compose_multiplatform
import joeyjupitertictactoe3.composeapp.generated.resources.favorites
import joeyjupitertictactoe3.composeapp.generated.resources.planets_array
import org.jetbrains.compose.resources.stringArrayResource
import org.jetbrains.compose.resources.stringResource

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally  //.CenterStart  /* Horizontal.CenterStart, //   .CenterHorizontally, */
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")

                    val resourceName = stringResource(Res.string.favorites)
                    Text(text = resourceName)

                    val planets3: List<String> = stringArrayResource(Res.array.planets_array)
                    planets3.forEach { planet ->
                        val textAlign = null
                        Text(
                            text = planet,
                            textAlign = TextAlign.Left // Use a parameter for component-specific styling
                        )
                    }
                }
            }
        }
    }
}


