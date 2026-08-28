package com.example.recipecomposeapp.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.recipecomposeapp.ui.categories.CategoriesScreen
import com.example.recipecomposeapp.ui.details.RecipeDetailsScreen
import com.example.recipecomposeapp.ui.favorites.FavoritesScreen
import com.example.recipecomposeapp.ui.recipes.RecipesScreen
import kotlinx.coroutines.delay

@Composable
fun AppNavHost(
    navController: NavHostController,
    deepLinkIntent: Intent?,
) {
    LaunchedEffect(deepLinkIntent) {
        deepLinkIntent?.data?.let { uri ->
            val recipeId: Int? = when (uri.scheme) {
                "recipeapp" ->
                    // recipeapp://recipe/123 → host="recipe", pathSegments=[123]
                    if (uri.host == "recipe") uri.pathSegments[0].toIntOrNull() else null
                "https", "http" ->
                    // https://.../recipe/123 → pathSegments=[recipe, 123]
                    if (uri.pathSegments[0] == "recipe") uri.pathSegments[1].toIntOrNull() else null
                else -> null
            }

            if (recipeId != null) {
                delay(100) // даем время на инициализацию графа
                navController.navigate(Destination.Recipe.createRoute(recipeId))
            }
        }
    }

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
            val recipeId = backStackEntry.arguments?.getInt("recipeId") ?: 0
            RecipeDetailsScreen(
                recipeId = recipeId,
            )
        }

        composable(route = Destination.Favorites.route) {
            FavoritesScreen()
        }
    }
}