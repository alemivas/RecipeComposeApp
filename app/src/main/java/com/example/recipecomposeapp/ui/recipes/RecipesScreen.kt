package com.example.recipecomposeapp.ui.recipes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.recipecomposeapp.R
import com.example.recipecomposeapp.core.ui.ScreenHeader
import com.example.recipecomposeapp.data.repository.getRecipesByCategoryId
import com.example.recipecomposeapp.ui.recipes.model.RecipeUiModel
import com.example.recipecomposeapp.ui.recipes.model.toUiModel
import com.example.recipecomposeapp.ui.theme.Dimens

@Composable
fun RecipesScreen(
    categoryId: Int?,
    categoryTitle: String,
    modifier: Modifier = Modifier,
    onRecipeClick: (Int) -> Unit,
) {
    var recipes by remember { mutableStateOf<List<RecipeUiModel>>(emptyList()) }

    LaunchedEffect(categoryId) {
        categoryId?.let {
            recipes = getRecipesByCategoryId(it).map { dto -> dto.toUiModel() }
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Column {
            ScreenHeader(
                imagePainter = painterResource(R.drawable.bcg_recipes_list),
                contentDescription = "Фоновая фотография еды",
                title = categoryTitle.uppercase(),
            )

            Spacer(modifier = Modifier.height(Dimens.paddingMain))

            if (categoryId != null) {
                LazyColumn(
                    contentPadding = PaddingValues(
                        start = Dimens.paddingMain,
                        end = Dimens.paddingMain,
                        bottom = Dimens.paddingMain
                    ),
                    verticalArrangement = Arrangement.spacedBy(Dimens.paddingMain),
                ) {
                    items(recipes, key = { it.id }) { recipe ->
                        RecipeItem(
                            recipe = recipe,
                            onClick = { onRecipeClick(recipe.id) },
                        )
                    }
                }
            } else {
                Text(
                    text = "Выберите категорию для отображения списка рецептов",
                    modifier = Modifier.padding(Dimens.paddingMain)
                )
            }
        }
    }
}