package com.example.recipecomposeapp.core.utils

import android.content.Context
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first

//import android.content.SharedPreferences
//import androidx.core.content.edit

class FavoriteDataStoreManager(
//    context: Context,
    val context: Context,
) {
//    private val sharedPreferences: SharedPreferences =
//        context.getSharedPreferences("recipe_app_prefs", Context.MODE_PRIVATE)
//    private val context = context


//    companion object {
//        private const val KEY_FAVORITE_RECIPES = "favorite_recipe_ids"
//    }

//    fun getAllFavorites(): Set<String> {
//        return sharedPreferences.getStringSet(KEY_FAVORITE_RECIPES, emptySet()) ?: emptySet()
//    }

    //    fun isFavorite(recipeId: Int): Boolean {
//        return getAllFavorites().contains(recipeId.toString())
//    }
    suspend fun isFavorite(recipeId: Int/*, context: Context*/): Boolean {
        val preferences = context.dataStore.data.first()
        val favoriteIds = preferences[PreferencesKeys.FAVORITE_RECIPE_IDS] ?: emptySet()
        return favoriteIds.contains(recipeId.toString())
    }

    //    fun addToFavorites(recipeId: Int) {
//        val currentFavorites = getAllFavorites()
//        val updatedFavorites = currentFavorites.toMutableSet()
//        updatedFavorites.add(recipeId.toString())
//        sharedPreferences.edit {
//            putStringSet(KEY_FAVORITE_RECIPES, updatedFavorites)
//        }
//    }
    suspend fun addFavorite(recipeId: Int) {
        context.dataStore.edit { preferences ->
            val currentFavorites = preferences[PreferencesKeys.FAVORITE_RECIPE_IDS] ?: emptySet()
            val updatedFavorites = currentFavorites + recipeId.toString()
            preferences[PreferencesKeys.FAVORITE_RECIPE_IDS] = updatedFavorites
        }
    }

    //    fun removeFromFavorites(recipeId: Int) {
//        val currentFavorites = getAllFavorites()
//        val updatedFavorites = currentFavorites.toMutableSet()
//        updatedFavorites.remove(recipeId.toString())
//        sharedPreferences.edit {
//            putStringSet(KEY_FAVORITE_RECIPES, updatedFavorites)
//        }
//    }
    suspend fun removeFavorite(recipeId: Int) {
        context.dataStore.edit { preferences ->
            val currentFavorites = preferences[PreferencesKeys.FAVORITE_RECIPE_IDS] ?: emptySet()
//            val updatedFavorites = currentFavorites + recipeId.toString()
            val updatedFavorites = currentFavorites.toMutableSet()
//            val updatedFavorites = currentFavorites.remove(recipeId.toString())
            updatedFavorites.remove(recipeId.toString())
            preferences[PreferencesKeys.FAVORITE_RECIPE_IDS] = updatedFavorites
        }
    }
}