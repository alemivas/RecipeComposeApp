package com.example.recipecomposeapp.ui.categories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.recipecomposeapp.R
import com.example.recipecomposeapp.ui.components.ScreenHeader

@Composable
fun CategoriesScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column {
            ScreenHeader(
                imagePainter = painterResource(R.drawable.bcg_categories),
                contentDescription = "Фоновая фотография еды",
                title = "КАТЕГОРИИ",
            )
            Text("Список категорий")
        }
    }
}