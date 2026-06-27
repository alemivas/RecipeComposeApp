package com.example.recipecomposeapp.ui.recipes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.recipecomposeapp.R
import com.example.recipecomposeapp.ui.components.ScreenHeader
import com.example.recipecomposeapp.ui.theme.Dimens

@Composable
fun RecipesScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column {
            ScreenHeader(
                imagePainter = painterResource(R.drawable.bcg_recipes_list),
                contentDescription = "Фоновая фотография еды",
                title = "РЕЦЕПТЫ",
            )
            Text(
                text = "Скоро здесь будет список рецептов",
                modifier = Modifier.padding(Dimens.paddingMain)
            )
        }
    }
}