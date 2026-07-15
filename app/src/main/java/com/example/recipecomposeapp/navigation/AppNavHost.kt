package com.example.recipecomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
        composable (route = Destination.Categories.route) {
            CategoriesScreen(
//                onCategoryClick = { categoryId ->
                onCategoryClick = {
                    navController.navigate(Destination.Recipes.route)
//                    navController.navigate("recipes/$categoryId")
                },
            )
        }

        composable (route = Destination.Recipes.route) {
            RecipesScreen(
                onRecipeClick = {
                    navController.popBackStack()
                }
            )
        }

        composable (route = Destination.Favorites.route) {
            FavoritesScreen()
        }
    }
}