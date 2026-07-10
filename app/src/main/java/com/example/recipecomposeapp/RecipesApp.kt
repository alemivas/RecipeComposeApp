package com.example.recipecomposeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipecomposeapp.ui.categories.CategoriesScreen
import com.example.recipecomposeapp.ui.favorites.FavoritesScreen
import com.example.recipecomposeapp.ui.navigation.BottomNavigation
import com.example.recipecomposeapp.ui.recipes.RecipesScreen
import com.example.recipecomposeapp.ui.theme.RecipeAppTheme

@Composable
fun RecipesApp() {
    RecipeAppTheme {
        var currentScreen by remember { mutableStateOf(ScreenId.CATEGORIES) }
        var selectedCategoryId by remember { mutableStateOf<Int?>(null) }
        var selectedCategoryTitle by remember { mutableStateOf("") }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomNavigation(
                    onCategoriesClick = { currentScreen = ScreenId.CATEGORIES },
                    onFavoriteClick = { currentScreen = ScreenId.FAVORITES },
                    onRecipesClick = { currentScreen = ScreenId.RECIPES },
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
            ) {
                when (currentScreen) {
                    ScreenId.CATEGORIES -> CategoriesScreen(
                        onCategoryClick = { categoryId, categoryTitle ->
                            selectedCategoryId = categoryId
                            selectedCategoryTitle = categoryTitle
                            currentScreen = ScreenId.RECIPES
                        }
                    )
                    ScreenId.FAVORITES -> FavoritesScreen()
                    ScreenId.RECIPES -> RecipesScreen(
                        categoryId = selectedCategoryId,
                        categoryTitle = selectedCategoryTitle,
                        onRecipeClick = {},
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RecipesAppPreview() {
    RecipesApp()
}