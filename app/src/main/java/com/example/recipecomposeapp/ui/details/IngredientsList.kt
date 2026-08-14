package com.example.recipecomposeapp.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.recipecomposeapp.ui.recipes.model.IngredientUiModel
import com.example.recipecomposeapp.ui.theme.Dimens

@Composable
fun IngredientsList(
    ingredients: List<IngredientUiModel>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(size = Dimens.cornerRadius),
            )
            .padding(Dimens.paddingMediumLarge)
    ) {
        if (ingredients.isNotEmpty()) {
            ingredients.forEachIndexed { index, ingredient ->
                IngredientItem(
                    ingredient = ingredient,
    //                modifier = Modifier.padding(horizontal = Dimens.paddingMediumLarge),
                )
                if (index < ingredients.lastIndex)
                    HorizontalDivider(
    //                    modifier = Modifier.padding(horizontal = Dimens.paddingMediumLarge),
                        modifier = Modifier.padding(vertical = Dimens.paddingMedium),
                        thickness = Dimens.dividerThickness,
                        color = MaterialTheme.colorScheme.outline
                    )
            }
        } else {
            Text(
                text = "Список ингредиентов пуст",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}