package com.example.recipecomposeapp.ui.details

import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import kotlin.math.roundToInt

@Composable
fun PortionsSlider(
    currentPortions: Int,
    onPortionsChange: (Int) -> Unit
) {
    Slider(
        value = currentPortions.toFloat(),
        onValueChange = { onPortionsChange(it.roundToInt()) },
        valueRange = 1f..12f,
        steps = 10
    )
}