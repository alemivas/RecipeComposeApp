package com.example.recipecomposeapp.features.categories.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recipecomposeapp.R
import com.example.recipecomposeapp.core.ui.ErrorScreen
import com.example.recipecomposeapp.core.ui.ScreenHeader
import com.example.recipecomposeapp.features.categories.presentation.CategoriesViewModel
import com.example.recipecomposeapp.ui.theme.Dimens

@Composable
fun CategoriesScreen(
    onCategoryClick: (Int, String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CategoriesViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        uiState.error?.let {
            ErrorScreen(it)
        } ?: Box(
            modifier = modifier.fillMaxSize(),
        ) {
            Column {
                ScreenHeader(
                    imagePainter = painterResource(R.drawable.bcg_categories),
                    contentDescription = "Фоновая фотография еды",
                    title = "КАТЕГОРИИ",
                )

                Spacer(modifier = Modifier.height(Dimens.paddingMain))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(
                        start = Dimens.paddingMain,
                        end = Dimens.paddingMain,
                        bottom = Dimens.paddingMain
                    ),
                    horizontalArrangement = Arrangement.spacedBy(Dimens.paddingMain),
                    verticalArrangement = Arrangement.spacedBy(Dimens.paddingMain),
                    modifier = Modifier.weight(1f),
                ) {
                    items(uiState.categories, key = { it.id }) { category ->
                        CategoryItem(
                            category = category,
                            onClick = {
                                onCategoryClick(
                                    category.id,
                                    category.title,
                                    category.imageUrl
                                )
                            },
                        )
                    }
                }
            }
        }
    }
}