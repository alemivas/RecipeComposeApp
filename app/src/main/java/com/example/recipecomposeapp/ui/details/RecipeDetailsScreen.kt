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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import coil3.compose.rememberAsyncImagePainter
import com.example.recipecomposeapp.core.ui.ScreenHeader
import com.example.recipecomposeapp.data.repository.getRecipeById
import com.example.recipecomposeapp.ui.error.ErrorScreen
import com.example.recipecomposeapp.ui.recipes.model.RecipeUiModel
import com.example.recipecomposeapp.ui.recipes.model.toUiModel
import com.example.recipecomposeapp.ui.theme.Dimens

@Composable
fun RecipeDetailsScreen(
//    recipe: RecipeUiModel,
    recipeId: Int,
    modifier: Modifier = Modifier,
) {
    var recipeById by remember { mutableStateOf<RecipeUiModel?>(null) }

    LaunchedEffect(recipeId) {
//        recipeId?.let {
        recipeId.let {
            recipeById = getRecipeById(it)?.toUiModel()
        }
    }

//    recipeById?.let {
    if (recipeById != null) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
//            val imagePainter = rememberAsyncImagePainter(model = recipe.imageUrl)
            val imagePainter = rememberAsyncImagePainter(model = recipeById!!.imageUrl)
            ScreenHeader(
                imagePainter = imagePainter,
//                contentDescription = recipe.title,
                contentDescription = recipeById!!.title,
//                title = recipe.title.uppercase(),
                title = recipeById!!.title.uppercase(),
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
//                ingredients = recipe.ingredients,
                ingredients = recipeById!!.ingredients,
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
//                method = recipe.method,
                method = recipeById!!.method,
                modifier = Modifier.padding(horizontal = Dimens.paddingMain),
            )
        }
    } else {
        ErrorScreen("Рецепт не найден")
    }
}