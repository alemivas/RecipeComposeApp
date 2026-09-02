package com.example.recipecomposeapp.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.recipecomposeapp.R
import com.example.recipecomposeapp.ui.theme.Dimens

@Composable
fun ScreenHeader(
    imagePainter: Painter,
    contentDescription: String = "",
    title: String = "",
    showShareButton: Boolean = false,
    onShareClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier.height(Dimens.HeaderHeight)
    ) {
        Image(
            painter = imagePainter,
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

        Surface(
            shape = RoundedCornerShape(size = Dimens.cornerRadius),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(Dimens.paddingMain),
        ) {
            Text(
                modifier = Modifier.padding(Dimens.paddingMediumLarge),
                text = title,
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.primary,
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(Dimens.paddingMain),
        ) {
            if (showShareButton) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_share),
                    contentDescription = "Поделиться",
                    modifier = Modifier
                        .size(Dimens.iconSizeLarge)
                        .clickable(onClick = onShareClick),
                    tint = MaterialTheme.colorScheme.onTertiary,
                )
            }
        }
    }
}