package com.example.recipecomposeapp.data.repository

import com.example.recipecomposeapp.data.model.CategoryDto
import com.example.recipecomposeapp.data.model.IngredientDto
import com.example.recipecomposeapp.data.model.RecipeDto

private val categories = listOf(
    CategoryDto(id = 0, title = "Бургеры", description = "Рецепты всех популярных видов бургеров", imageUrl = "burger.png"),
    CategoryDto(id = 1, title = "Десерты", description = "Самые вкусные рецепты десертов специально для вас", imageUrl = "dessert.png"),
    CategoryDto(id = 2, title = "Пицца", description = "Пицца на любой вкус и цвет. Лучшая подборка для тебя", imageUrl = "pizza.png"),
    CategoryDto(id = 3, title = "Рыба", description = "Печеная, жареная, сушеная, любая рыба на твой вкус", imageUrl = "fish.png"),
    CategoryDto(id = 4, title = "Супы", description = "От классики до экзотики: мир в одной тарелке", imageUrl = "soup.png"),
    CategoryDto(id = 5, title = "Салаты", description = "Хрустящий калейдоскоп под соусом вдохновения", imageUrl = "salad.png"),
)

private val burgerRecipes = listOf(
    RecipeDto(id = 0, title = "Классический бургер с говядиной", ingredients = listOf(
        IngredientDto(quantity = 0.5)
    ), method, imageUrl)
)