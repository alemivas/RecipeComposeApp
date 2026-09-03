package com.example.recipecomposeapp

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.recipecomposeapp.data.repository.getCategories
import com.example.recipecomposeapp.navigation.AppNavHost
import com.example.recipecomposeapp.navigation.Destination
import com.example.recipecomposeapp.ui.categories.model.toUiModel
import com.example.recipecomposeapp.ui.navigation.BottomNavigation
import com.example.recipecomposeapp.ui.theme.RecipeAppTheme

@Composable
fun RecipesApp(deepLinkIntent: Intent?) {
    RecipeAppTheme {
        val navController = rememberNavController()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomNavigation(
                    onCategoriesClick = { navController.navigate(Destination.Categories.route) },
                    onFavoriteClick = { navController.navigate(Destination.Favorites.route) },
                    onRecipesClick = {
                        val category = getCategories().first().toUiModel()
                        navController.navigate(
                            Destination.Recipes.createRoute(
                                categoryId = category.id, categoryTitle = category.title
                            )
                        )
                    },
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
            ) {
                AppNavHost(navController, deepLinkIntent)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RecipesAppPreview() {
    RecipesApp(
        deepLinkIntent = null
    )
}