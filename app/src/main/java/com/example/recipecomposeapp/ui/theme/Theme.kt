package com.example.recipecomposeapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val RecipesAppDarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80
    primary = PrimaryColorDark,
    error = AccentColorDark,
    onError = TextPrimaryColorDark,
    tertiary = AccentBlueDark,
    onTertiary = TextPrimaryColorDark,
    tertiaryContainer = SliderTrackColorDark,
    onTertiaryContainer = AccentBlueDark,
    background  = BackgroundColorDark,
    onBackground = PrimaryColorDark,
    surface = SurfaceColorDark,
    onSurface = TextSecondaryColorDark,
    outline = DividerColorDark,
    surfaceVariant = SurfaceVariantColorDark,
    onSurfaceVariant = BackgroundColorDark,
)

//private val LightColorScheme = lightColorScheme(
private val RecipesAppLightColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */

    primary = PrimaryColor,
    error = AccentColor,
    onError = TextPrimaryColor,
    tertiary = AccentBlue,
    onTertiary = TextPrimaryColor,
    tertiaryContainer = SliderTrackColor,
    onTertiaryContainer = AccentBlue,
    background  = BackgroundColor,
    onBackground = PrimaryColor,
    surface = SurfaceColor,
    onSurface = TextSecondaryColor,
    outline = DividerColor,
    surfaceVariant = SurfaceVariantColor,
    onSurfaceVariant = BackgroundColor,
)

@Composable
fun RecipeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }

    val colorScheme = if (darkTheme) RecipesAppDarkColorScheme else RecipesAppLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = recipesAppTypography,
        content = content
    )
}