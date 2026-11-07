package com.example.recipecomposeapp.data.repository

import com.example.recipecomposeapp.data.model.CategoryDto
import com.example.recipecomposeapp.data.model.RecipeDto

interface RecipesRepository {
    fun getCategories(): List<CategoryDto>
    fun getRecipesByCategoryId(categoryId: Int): List<RecipeDto>
    fun getRecipeById(recipeId: Int?): RecipeDto?
}