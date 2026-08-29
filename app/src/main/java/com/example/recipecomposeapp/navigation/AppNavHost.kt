package com.example.recipecomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.recipecomposeapp.ui.categories.CategoriesScreen
import com.example.recipecomposeapp.ui.details.RecipeDetailsScreen
import com.example.recipecomposeapp.ui.favorites.FavoritesScreen
import com.example.recipecomposeapp.ui.recipes.RecipesScreen

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
                        Destination.Recipes.createRoute(categoryId, categoryTitle)
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
                onRecipeClick = { recipeId ->
                    navController.navigate(
                        Destination.Recipe.createRoute(recipeId)
                    )
                },
            )
        }

        composable(
            route = Destination.Recipe.route,
            arguments = listOf(
                navArgument("recipeId") { type = NavType.IntType },
            ),
        ) { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getInt("recipeId")
            RecipeDetailsScreen(
                recipeId = recipeId,
            )
        }

        composable(route = Destination.Favorites.route) {
            FavoritesScreen()
        }
    }
}