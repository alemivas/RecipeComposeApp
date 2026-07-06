package com.example.recipecomposeapp.ui.categories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.recipecomposeapp.R
import com.example.recipecomposeapp.core.ui.ScreenHeader
import com.example.recipecomposeapp.data.repository.getCategories
import com.example.recipecomposeapp.ui.categories.model.toUiModel
import com.example.recipecomposeapp.ui.theme.Dimens

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
//    onCategoryClick: (Int) -> Unit,
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Column {
            ScreenHeader(
                imagePainter = painterResource(R.drawable.bcg_categories),
                contentDescription = "Фоновая фотография еды",
                title = "КАТЕГОРИИ",
            )
            Text(
                text = "Заглушка: Список категорий",
                modifier = Modifier.padding(Dimens.paddingMain)
            )
//            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(getCategories()) { category ->
                    CategoryItem(
                        category = category.toUiModel(),
                        onClick = {},
        //                onClick = onCategoryClick,
                    )
                }
            }
        }
    }
}