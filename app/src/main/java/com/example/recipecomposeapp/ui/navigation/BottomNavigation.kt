package com.example.recipecomposeapp.ui.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipecomposeapp.core.utils.FavoriteDataStoreManager
import com.example.recipecomposeapp.ui.theme.Dimens
import com.example.recipecomposeapp.ui.theme.RecipeAppTheme

@Composable
fun BottomNavigation(
    onCategoriesClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onRecipesClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = Dimens.paddingMain, vertical = Dimens.paddingMedium)
            .navigationBarsPadding(),
    ) {
        Button(
            modifier = Modifier
                .weight(1f)
                .height(Dimens.buttonHeight),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.onTertiary,
            ),
            shape = RoundedCornerShape(size = Dimens.cornerRadius),
            onClick = onCategoriesClick,
        ) {
            Text("Категории")
        }
        Spacer(modifier = Modifier.width(Dimens.paddingSmall))
        val context = LocalContext.current
        val favoriteManager = remember(context) { FavoriteDataStoreManager(context) }
        val favoriteCount by favoriteManager
            .getFavoriteCountFlow()
            .collectAsState(initial = 0)
        Button(
            modifier = Modifier
                .weight(1f)
                .height(Dimens.buttonHeight),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error,
                contentColor = MaterialTheme.colorScheme.onError,
            ),
            shape = RoundedCornerShape(size = Dimens.cornerRadius),
            onClick = onFavoriteClick,
        ) {
            Text("${if (favoriteCount > 0) "$favoriteCount " else ""}Избранное")
        }
        Spacer(modifier = Modifier.width(Dimens.paddingSmall))
        Button(
            modifier = Modifier
                .weight(1f)
                .height(Dimens.buttonHeight),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.onTertiary,
            ),
            shape = RoundedCornerShape(size = Dimens.cornerRadius),
            onClick = onRecipesClick,
        ) {
            Text("Рецепты")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BottomNavigationPreview() {
    RecipeAppTheme {
        BottomNavigation(
            onCategoriesClick = {},
            onFavoriteClick = {},
            onRecipesClick = {},
        )
    }
}