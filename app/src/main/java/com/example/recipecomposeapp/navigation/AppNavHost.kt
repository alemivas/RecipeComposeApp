package com.example.recipecomposeapp.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.recipecomposeapp.core.utils.FavoriteDataStoreManager
import com.example.recipecomposeapp.data.repository.RecipesRepositoryStub
import com.example.recipecomposeapp.features.categories.presentation.CategoriesViewModel
import com.example.recipecomposeapp.features.categories.ui.CategoriesScreen
import com.example.recipecomposeapp.features.details.ui.RecipeDetailsScreen
import com.example.recipecomposeapp.features.favorites.ui.FavoritesScreen
import com.example.recipecomposeapp.features.recipes.ui.RecipesScreen
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
                    if (uri.host == "recipe")
                        uri.pathSegments.getOrNull(0)?.toIntOrNull()
                    else null

                "https", "http" ->
                    // https://.../recipe/123 → pathSegments=[recipe, 123]
                    if (uri.pathSegments.getOrNull(0) == "recipe")
                        uri.pathSegments.getOrNull(1)?.toIntOrNull()
                    else null

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
            val viewModel: CategoriesViewModel = viewModel {
                CategoriesViewModel(RecipesRepositoryStub)
            }
            CategoriesScreen(
                onCategoryClick = { categoryId, categoryTitle, categoryImageUrl ->
                    navController.navigate(
                        Destination.Recipes.createRoute(categoryId, categoryTitle, categoryImageUrl)
                    )
                },
                viewModel = viewModel,
            )
        }

        composable(
            route = Destination.Recipes.route,
            arguments = listOf(
                navArgument("categoryId") { type = NavType.IntType },
                navArgument("categoryTitle") { type = NavType.StringType },
                navArgument("categoryImageUrl") { type = NavType.StringType },
            ),
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: 0
            val categoryTitle = backStackEntry.arguments?.getString("categoryTitle") ?: ""
            val categoryImageUrl = backStackEntry.arguments?.getString("categoryImageUrl") ?: ""
            RecipesScreen(
                categoryId = categoryId,
                categoryTitle = categoryTitle,
                categoryImageUrl = categoryImageUrl,
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
            val recipesRepository = RecipesRepositoryStub
            val context = LocalContext.current
            val favoriteManager = remember(context) { FavoriteDataStoreManager(context) }
            FavoritesScreen(
                recipesRepository = recipesRepository,
                favoriteManager = favoriteManager,
                onRecipeClick = { recipeId ->
                    navController.navigate(
                        Destination.Recipe.createRoute(recipeId)
                    )
                },
            )
        }
    }
}