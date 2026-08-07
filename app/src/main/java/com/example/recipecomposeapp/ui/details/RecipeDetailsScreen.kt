package com.example.recipecomposeapp.ui.details

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipecomposeapp.ui.recipes.model.RecipeUiModel
import com.example.recipecomposeapp.ui.theme.Dimens

@Composable
fun RecipeDetailsScreen(
    recipe: RecipeUiModel?,
    modifier: Modifier = Modifier,
) {
    if (recipe != null) {
        Text(
            text = recipe.title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = modifier.padding(Dimens.paddingMain)
        )
    } else {
        Text(
            text = "Рецепт не найден",
            style = MaterialTheme.typography.headlineMedium,
            modifier = modifier.padding(Dimens.paddingMain)
        )
    }
}