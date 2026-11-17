package com.example.recipecomposeapp.features.recipes.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil3.compose.rememberAsyncImagePainter
import com.example.recipecomposeapp.core.ui.ErrorScreen
import com.example.recipecomposeapp.core.ui.ScreenHeader
import com.example.recipecomposeapp.features.recipes.presentation.RecipesViewModel
import com.example.recipecomposeapp.ui.theme.Dimens

@Composable
fun RecipesScreen(
    onRecipeClick: (Int) -> Unit,
    viewModel: RecipesViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        uiState.error?.let {
            ErrorScreen(it)
        } ?: Box(
            modifier = modifier.fillMaxSize(),
        ) {
            Column {
                val imagePainter = rememberAsyncImagePainter(model = uiState.categoryImageUrl)
                ScreenHeader(
                    imagePainter = imagePainter,
                    contentDescription = "Фоновая фотография еды",
                    title = uiState.categoryTitle.uppercase(),
                )

                Spacer(modifier = Modifier.height(Dimens.paddingMain))

                if (uiState.categoryId != null) {
                    if (uiState.recipes.isNotEmpty()) {
                        LazyColumn(
                            contentPadding = PaddingValues(
                                start = Dimens.paddingMain,
                                end = Dimens.paddingMain,
                                bottom = Dimens.paddingMain
                            ),
                            verticalArrangement = Arrangement.spacedBy(Dimens.paddingMain),
                            modifier = Modifier.weight(1f),
                        ) {
                            items(uiState.recipes, key = { it.id }) { recipe ->
                                RecipeItem(
                                    recipe = recipe,
                                    onClick = onRecipeClick,
                                )
                            }
                        }
                    } else {
                        ErrorScreen("Список рецептов пуст")
                    }
                } else {
                    ErrorScreen("Выберите категорию для отображения списка рецептов")
                }
            }
        }
    }
}