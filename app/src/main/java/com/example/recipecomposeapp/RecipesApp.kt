package com.example.recipecomposeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.recipecomposeapp.navigation.AppNavHost
import com.example.recipecomposeapp.navigation.Destination
import com.example.recipecomposeapp.ui.navigation.BottomNavigation
import com.example.recipecomposeapp.ui.theme.RecipeAppTheme

@Composable
fun RecipesApp() {
    RecipeAppTheme {
//        var currentScreen by remember { mutableStateOf(ScreenId.CATEGORIES) }
//        var selectedCategoryId by remember { mutableStateOf<Int?>(null) }
//        var selectedCategoryTitle by remember { mutableStateOf("") }
        val navController = rememberNavController()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomNavigation(
//                    onCategoriesClick = { currentScreen = ScreenId.CATEGORIES },
                    onCategoriesClick = { navController.navigate(Destination.Categories.route) },
//                    onFavoriteClick = { currentScreen = ScreenId.FAVORITES },
                    onFavoriteClick = { navController.navigate(Destination.Favorites.route) },
//                    onRecipesClick = { currentScreen = ScreenId.RECIPES },
//                    onRecipesClick = { navController.navigate(Destination.Recipes.route) },
                    onRecipesClick = { navController.navigate(Destination.Recipes.createRoute(categoryId = 0, categoryTitle = "")) },
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
            ) {
//                when (currentScreen) {
//                    ScreenId.CATEGORIES -> CategoriesScreen(
//                        onCategoryClick = { categoryId, categoryTitle ->
//                            selectedCategoryId = categoryId
//                            selectedCategoryTitle = categoryTitle
//                            currentScreen = ScreenId.RECIPES
//                        }
//                    )
//                    ScreenId.FAVORITES -> FavoritesScreen()
//                    ScreenId.RECIPES -> RecipesScreen(
//                        categoryId = selectedCategoryId,
//                        categoryTitle = selectedCategoryTitle,
//                        onRecipeClick = { recipeId ->
//                            Log.d("click", "Recipe id=$recipeId clicked")
//                        },
//                    )
//                }


//                val navController = rememberNavController()
                AppNavHost(navController)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RecipesAppPreview() {
    RecipesApp()
}