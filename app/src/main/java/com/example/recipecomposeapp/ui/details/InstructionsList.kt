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
import com.example.recipecomposeapp.ui.theme.Dimens

@Composable
fun InstructionsList(
    method: List<String>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(size = Dimens.cornerRadius),
            )
            .padding(Dimens.paddingMediumLarge)
//            .background(color = Color.Cyan),
    ) {
        if (method.isNotEmpty()) {
            method.forEachIndexed { index, item ->
                InstructionItem(
                    item = item,
    //                modifier = Modifier.padding(horizontal = Dimens.paddingMediumLarge),
                )
                if (index < method.lastIndex)
                    HorizontalDivider(
    //                    modifier = Modifier.padding(horizontal = Dimens.paddingMediumLarge),
                        modifier = Modifier.padding(vertical = Dimens.paddingMedium),
                        thickness = Dimens.dividerThickness,
                        color = MaterialTheme.colorScheme.outline
                    )
            }
        } else {
            Text(
                text = "Способ приготовления пуст",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}