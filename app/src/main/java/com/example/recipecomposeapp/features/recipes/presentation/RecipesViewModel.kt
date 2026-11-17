package com.example.recipecomposeapp.features.recipes.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipecomposeapp.data.repository.RecipesRepository
import com.example.recipecomposeapp.features.recipes.presentation.model.RecipesUiState
import com.example.recipecomposeapp.features.recipes.presentation.model.toUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.concurrent.CancellationException

class RecipesViewModel(
    savedStateHandle: SavedStateHandle,
    private val recipesRepository: RecipesRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(RecipesUiState())
    val uiState: StateFlow<RecipesUiState> = _uiState.asStateFlow()

    private val categoryId = savedStateHandle["categoryId"] ?: 0
    private val categoryTitle = savedStateHandle["categoryTitle"] ?: ""
    private val categoryImageUrl = savedStateHandle["categoryImageUrl"] ?: ""

    init {
        viewModelScope.launch {
            try {
                _uiState.update { currentState ->
                    currentState.copy(
                        recipes = recipesRepository.getRecipesByCategoryId(categoryId).map {
                            it.toUiModel()
                        },
                        isLoading = false,
                        categoryId = categoryId,
                        categoryTitle = categoryTitle,
                        categoryImageUrl = categoryImageUrl,
                    )
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = "Не удалось загрузить рецепты"
                    )
                }
            }
        }
    }
}