package com.example.recipecomposeapp.navigation

sealed class Destination(val route: String) {
    object Categories : Destination("categories")
//    object Recipes : Destination("recipes/{categoryId}") {
//        fun createRoute(categoryId: Int) = "recipes/$categoryId"
//    }
    object Recipes : Destination("recipes")
    object Favorites : Destination("favorites")
}