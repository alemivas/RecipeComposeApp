package com.example.recipecomposeapp.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.rememberAsyncImagePainter
import com.example.recipecomposeapp.core.ui.ScreenHeader
import com.example.recipecomposeapp.ui.recipes.model.RecipeUiModel
import com.example.recipecomposeapp.ui.theme.Dimens

@Composable
fun RecipeDetailsScreen(
    recipe: RecipeUiModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val imagePainter = rememberAsyncImagePainter(model = recipe.imageUrl)
        ScreenHeader(
            imagePainter = imagePainter,
            contentDescription = recipe.title,
            title = recipe.title.uppercase(),
        )

        Spacer(modifier = Modifier.height(Dimens.paddingMain))

        Text(
            text = "ИНГРЕДИЕНТЫ",
            modifier = Modifier.padding(horizontal = Dimens.paddingMain),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.primary,
        )

        Spacer(modifier = Modifier.height(Dimens.paddingMain))

        IngredientsList(
            ingredients = recipe.ingredients,
            modifier = Modifier.padding(horizontal = Dimens.paddingMain),
        )

        Spacer(modifier = Modifier.height(Dimens.paddingMain))

        Text(
            text = "СПОСОБ ПРИГОТОВЛЕНИЯ    ",
            modifier = Modifier.padding(horizontal = Dimens.paddingMain),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.primary,
        )

        Spacer(modifier = Modifier.height(Dimens.paddingMain))

        InstructionsList(
            method = recipe.method,
            modifier = Modifier.padding(horizontal = Dimens.paddingMain),
        )
    }
}