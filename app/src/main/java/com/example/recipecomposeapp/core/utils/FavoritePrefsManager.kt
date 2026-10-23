package com.example.recipecomposeapp.core.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class FavoritePrefsManager(
    context: Context,
) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("recipe_app_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_FAVORITE_RECIPES = "favorite_recipe_ids"
    }

    fun getAllFavorites(): Set<String> {
        return sharedPreferences.getStringSet(KEY_FAVORITE_RECIPES, emptySet()) ?: emptySet()
    }

    fun isFavorite(recipeId: Int): Boolean {
        return getAllFavorites().contains(recipeId.toString())
    }

    fun addToFavorites(recipeId: Int) {
        val currentFavorites = getAllFavorites()
        val updatedFavorites = currentFavorites.toMutableSet()
        updatedFavorites.add(recipeId.toString())
        sharedPreferences.edit {
            putStringSet(KEY_FAVORITE_RECIPES, updatedFavorites)
        }
    }

    fun removeFromFavorites(recipeId: Int) {
        val currentFavorites = getAllFavorites()
        val updatedFavorites = currentFavorites.toMutableSet()
        updatedFavorites.remove(recipeId.toString())
        sharedPreferences.edit {
            putStringSet(KEY_FAVORITE_RECIPES, updatedFavorites)
        }
    }
}