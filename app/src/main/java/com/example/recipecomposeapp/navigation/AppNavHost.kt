package com.example.recipecomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.recipecomposeapp.ui.categories.CategoriesScreen
import com.example.recipecomposeapp.ui.details.RecipeDetailsScreen
import com.example.recipecomposeapp.ui.error.ErrorScreen
import com.example.recipecomposeapp.ui.favorites.FavoritesScreen
import com.example.recipecomposeapp.ui.recipes.RecipesScreen
import com.example.recipecomposeapp.ui.recipes.model.RecipeUiModel

@Composable
fun AppNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Categories.route,
    ) {
        composable(route = Destination.Categories.route) {
            CategoriesScreen(
                onCategoryClick = { categoryId, categoryTitle ->
                    navController.navigate(
                        Destination.Recipes.createRoute(
                            categoryId,
                            categoryTitle
                        )
                    )
                },
            )
        }

        composable(
            route = Destination.Recipes.route,
            arguments = listOf(
                navArgument("categoryId") { type = NavType.IntType },
                navArgument("categoryTitle") { type = NavType.StringType }
            ),
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: 0
            val categoryTitle = backStackEntry.arguments?.getString("categoryTitle") ?: ""
            RecipesScreen(
                categoryId = categoryId,
                categoryTitle = categoryTitle,
                onRecipeClick = { recipeId, recipe ->
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        KEY_RECIPE_OBJECT,
                        recipe
                    )
                    navController.navigate(
                        Destination.Recipe.createRoute(recipeId)
                    )
                },
            )
        }

        composable(
            route = Destination.Recipe.route,
        ) {
            val recipe =
                navController.previousBackStackEntry?.savedStateHandle?.get<RecipeUiModel>(
                    KEY_RECIPE_OBJECT
                )
            if (recipe != null)
                RecipeDetailsScreen(recipe)
            else
                ErrorScreen("Рецепт не найден")
        }

        composable(route = Destination.Favorites.route) {
            FavoritesScreen()
        }
    }
}

const val KEY_RECIPE_OBJECT = "recipe"