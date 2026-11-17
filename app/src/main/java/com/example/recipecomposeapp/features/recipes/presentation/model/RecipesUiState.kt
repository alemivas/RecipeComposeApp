package com.example.recipecomposeapp.features.recipes.presentation.model

data class RecipesUiState(
    val categoryId: Int? = null,
    val categoryTitle: String = "",
    val categoryImageUrl: String = "",
    val recipes: List<RecipeUiModel> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null,
)
