package com.example.recipecomposeapp.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.recipecomposeapp.ui.categories.CategoriesScreen
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
//                onCategoryClick = {
//                    navController.navigate("${Destination.Recipes.route}/$categoryId")
                    navController.navigate(Destination.Recipes.createRoute(categoryId, categoryTitle))
//                    navController.navigate("recipes/$categoryId")
                },
            )
        }

        composable(
            route = Destination.Recipes.route,
//            arguments = listOf(navArgument("categoryId") { type = NavType.IntType }),
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
//                onRecipeClick = {
//                    navController.popBackStack()
//                }
                onRecipeClick = { recipeId ->
                    Log.d("click", "Recipe id=$recipeId clicked")
                },
            )
        }

        composable(route = Destination.Favorites.route) {
            FavoritesScreen()
        }
    }
}