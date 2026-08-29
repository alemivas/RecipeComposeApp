package com.example.recipecomposeapp.ui.details

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import com.example.recipecomposeapp.ui.theme.Dimens
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortionsSelector(
    currentPortions: Int,
    onPortionsChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = "Порции: $currentPortions",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(vertical = Dimens.paddingSmall)
        )

        Slider(
            value = currentPortions.toFloat(),
            onValueChange = { onPortionsChange(it.roundToInt()) },
            valueRange = 1f..12f,
            steps = 10,
            modifier = Modifier.height(Dimens.sliderThumpHeight),
            thumb = {
                Box(
                    modifier = Modifier
                        .size(
                            width = Dimens.sliderThumpWidth,
                            height = Dimens.sliderThumpHeight
                        )
                        .clip(RoundedCornerShape(Dimens.sliderThumpRadius))
                        .background(color = MaterialTheme.colorScheme.tertiary)
                )
            },
            track = {
                val trackColor = MaterialTheme.colorScheme.tertiaryContainer
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(Dimens.sliderTrackHeight)
                ) {
                    val radiusPx = Dimens.sliderTrackRadius.toPx()
                    drawRoundRect(
                        color = trackColor,
                        size = size,
                        cornerRadius = CornerRadius(radiusPx, radiusPx)
                    )
                }
            }
        )
    }
}