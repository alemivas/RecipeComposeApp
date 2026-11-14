package com.example.recipecomposeapp.navigation

import android.net.Uri


sealed class Destination(val route: String) {
    object Categories : Destination("categories")
    object Recipes : Destination("recipes/{categoryId}/{categoryTitle}/{categoryImageUrl}") {
        fun createRoute(categoryId: Int, categoryTitle: String, categoryImageUrl: String) =
            "recipes/$categoryId/${Uri.encode(categoryTitle)}/${Uri.encode(categoryImageUrl)}"
    }
    object Recipe : Destination("recipe/{recipeId}") {
        fun createRoute(recipeId: Int) =
            "recipe/$recipeId"
    }
    object Favorites : Destination("favorites")
}

const val DEEP_LINK_SCHEME = "recipeapp"
const val DEEP_LINK_BASE_URL = "https://recipes.androidsprint.ru"

fun createRecipeDeepLink(recipeId: Int) =
    "$DEEP_LINK_BASE_URL/recipe/$recipeId"