package com.example.recipecomposeapp.ui.details

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.recipecomposeapp.ui.recipes.model.IngredientUiModel

@Composable
fun InstructionItem(
    item: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically,
//        verticalAlignment = Alignment.Top,
    ) {
//        val textStyle = MaterialTheme.typography.bodyMedium
//        val textColor = MaterialTheme.colorScheme.onSurfaceVariant

        Text(
            text = item,
//            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}