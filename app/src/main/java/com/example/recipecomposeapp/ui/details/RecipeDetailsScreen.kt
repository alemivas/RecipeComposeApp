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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil3.compose.rememberAsyncImagePainter
import com.example.recipecomposeapp.core.ui.ScreenHeader
import com.example.recipecomposeapp.core.utils.shareRecipe
import com.example.recipecomposeapp.data.repository.getRecipeById
import com.example.recipecomposeapp.ui.error.ErrorScreen
import com.example.recipecomposeapp.ui.recipes.model.toUiModel
import com.example.recipecomposeapp.ui.theme.Dimens

@Composable
fun RecipeDetailsScreen(
    recipeId: Int?,
    modifier: Modifier = Modifier,
) {
    val recipe = getRecipeById(recipeId)?.toUiModel()

    recipe?.let { recipe ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            val context = LocalContext.current
            val imagePainter = rememberAsyncImagePainter(model = recipe.imageUrl)
//            var tempIsFavorite by remember { mutableStateOf(false) }
//            var tempIsFavorite by remember { mutableStateOf(recipe.isFavorite) }
            var isFavorite by rememberSaveable { mutableStateOf(recipe.isFavorite) }
            ScreenHeader(
                imagePainter = imagePainter,
                contentDescription = recipe.title,
                title = recipe.title.uppercase(),
                showFavoriteButton = true,
//                onFavoriteToggle = {},
                onFavoriteToggle = { isFavorite = !isFavorite },
                isFavorite = isFavorite,
                showShareButton = true,
                onShareClick = { shareRecipe(context, recipe.id, recipe.title) },
            )

            Spacer(modifier = Modifier.height(Dimens.paddingMain))

            Text(
                text = "ИНГРЕДИЕНТЫ",
                modifier = Modifier.padding(horizontal = Dimens.paddingMain),
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.primary,
            )

//            var currentPortions by remember { mutableIntStateOf(recipe.servings) }
            var currentPortions by rememberSaveable { mutableIntStateOf(recipe.servings) }
//            val scaledIngredients = remember(currentPortions) {
            val scaledIngredients = remember(recipe.ingredients, currentPortions) {
//                val multiplier = currentPortions.toDouble() / recipe.servings
                val multiplier = currentPortions.toFloat() / recipe.servings
                recipe.ingredients.map { ingredient ->
                    ingredient.copy(
                        quantity =
                            if (ingredient.quantity.toFloatOrNull() != null)
                                "%.2f".format(ingredient.quantity.toFloat() * multiplier)
                                    .trimEnd('0').trimEnd(',').trimEnd('.')
                            else
                                ingredient.quantity
                    )
                }
            }
            PortionsSelector(
                currentPortions = currentPortions,
                onPortionsChange = { currentPortions = it },
                modifier = Modifier.padding(horizontal = Dimens.paddingMain),
            )

            Spacer(modifier = Modifier.height(Dimens.paddingMain))

            IngredientsList(
                ingredients = scaledIngredients,
                modifier = Modifier.padding(horizontal = Dimens.paddingMain),
            )

            Spacer(modifier = Modifier.height(Dimens.paddingMain))

            Text(
                text = "СПОСОБ ПРИГОТОВЛЕНИЯ",
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
    } ?: ErrorScreen("Рецепт не найден")
}