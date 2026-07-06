package com.example.recipecomposeapp.ui.categories

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImage
import com.example.recipecomposeapp.R
import com.example.recipecomposeapp.ui.categories.model.CategoryUiModel
import com.example.recipecomposeapp.ui.theme.Dimens

@Composable
fun CategoryItem(
    category: CategoryUiModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(size = Dimens.cornerRadius),
        elevation = CardDefaults.cardElevation(defaultElevation = Dimens.elevation),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
    ) {
        AsyncImage(
//            model = "burger-hamburger.png",
//            model = "burger.png",
            model = category.imageUrl,
//            model = null,
            contentDescription = "Изображение категории ${category.title}",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.2f)
//                .clip(CircleShape)
                ,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.img_placeholder),
            error = painterResource(R.drawable.img_error),
//            error = painterResource(R.drawable.img_placeholder),
        )
        Column(
            modifier = Modifier.padding(Dimens.paddingMedium),
        )
        {
            Text(
                text = category.title.uppercase(),
//                modifier = Modifier.padding(Dimens.paddingMedium),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.height(Dimens.paddingMedium),)
            Text(
                text = category.description,
//                modifier = Modifier.padding(Dimens.paddingMedium),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 3,
            )
        }
    }
}