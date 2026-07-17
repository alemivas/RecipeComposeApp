package com.example.recipecomposeapp.navigation

import android.net.Uri


sealed class Destination(val route: String) {
    object Categories : Destination("categories")
    object Recipes : Destination("recipes/{categoryId}/{categoryTitle}") {
        //    object Recipes : Destination("recipes/0") {
        fun createRoute(categoryId: Int, categoryTitle: String) =
            "recipes/$categoryId/${Uri.encode(categoryTitle)}"
//            "recipes/$categoryId/${categoryTitle}"
    }

    //    object Recipes : Destination("recipes")
    object Favorites : Destination("favorites")
}