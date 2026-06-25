package com.example.recipecomposeapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val RecipesAppDarkColorScheme = darkColorScheme(
    primary = PrimaryColorDark,
    onPrimary = TextPrimaryColorDark,
    error = AccentColorDark,
    onError = TextPrimaryColorDark,
    tertiary = AccentBlueDark,
    onTertiary = TextPrimaryColorDark,
    tertiaryContainer = SliderTrackColorDark,
    onTertiaryContainer = AccentBlueDark,
    background  = BackgroundColorDark,
    onBackground = PrimaryColorDark,
    surface = SurfaceColorDark,
    onSurface = TextPrimaryColorDark,
    outline = DividerColorDark,
    surfaceVariant = SurfaceVariantColorDark,
    onSurfaceVariant = TextSecondaryColorDark,
)

private val RecipesAppLightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    onPrimary = TextPrimaryColor,
    error = AccentColor,
    onError = SurfaceColor,
    tertiary = AccentBlue,
    onTertiary = SurfaceColor,
    tertiaryContainer = SliderTrackColor,
    onTertiaryContainer = AccentBlue,
    background  = BackgroundColor,
    onBackground = PrimaryColor,
    surface = SurfaceColor,
    onSurface = TextPrimaryColor,
    outline = DividerColor,
    surfaceVariant = SurfaceVariantColor,
    onSurfaceVariant = TextSecondaryColor,
)

@Composable
fun RecipeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) RecipesAppDarkColorScheme else RecipesAppLightColorScheme,
        typography = recipesAppTypography,
        content = content
    )
}