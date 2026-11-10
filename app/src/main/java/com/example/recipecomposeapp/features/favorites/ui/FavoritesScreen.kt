package com.example.recipecomposeapp.features.favorites.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.recipecomposeapp.R
import com.example.recipecomposeapp.core.ui.ScreenHeader
import com.example.recipecomposeapp.core.utils.FavoriteDataStoreManager
import com.example.recipecomposeapp.data.repository.RecipesRepository
import com.example.recipecomposeapp.core.ui.ErrorScreen
import com.example.recipecomposeapp.features.recipes.ui.RecipeItem
import com.example.recipecomposeapp.features.recipes.presentation.model.toUiModel
import com.example.recipecomposeapp.ui.theme.Dimens
import kotlinx.coroutines.flow.map

@Composable
fun FavoritesScreen(
    recipesRepository: RecipesRepository,
    favoriteManager: FavoriteDataStoreManager,
    onRecipeClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val favoriteRecipes by remember(favoriteManager) {
        favoriteManager.getFavoriteIdsFlow().map { ids ->
            ids.mapNotNull { recipeId ->
                recipesRepository.getRecipeById(recipeId.toIntOrNull())?.toUiModel()
            }
        }
    }.collectAsState(initial = emptyList())

    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Column {
            ScreenHeader(
                imagePainter = painterResource(R.drawable.bcg_favorites),
                contentDescription = "Фоновая фотография еды",
                title = "ИЗБРАННОЕ",
            )

            Spacer(modifier = Modifier.height(Dimens.paddingMain))

            if (favoriteRecipes.isNotEmpty()) {
                LazyColumn(
                    contentPadding = PaddingValues(
                        start = Dimens.paddingMain,
                        end = Dimens.paddingMain,
                        bottom = Dimens.paddingMain
                    ),
                    verticalArrangement = Arrangement.spacedBy(Dimens.paddingMain),
                    modifier = Modifier.weight(1f),
                ) {
                    items(favoriteRecipes, key = { it.id }) { recipe ->
                        RecipeItem(
                            recipe = recipe,
                            onClick = onRecipeClick,
                        )
                    }
                }
            } else {
                ErrorScreen("Вы еще не добавили ни одного рецепта в избранное")
            }
        }
    }
}