package com.nmt.kmpcore.presentation.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Light Theme Colors
val DarkGrayPrimary = Color(0xFF4A4A4A)
val LightGrayButton = Color(0xFFB0B0B0)
val LightBackground = Color(0xFFF8F8F8)
val LightSurface = Color(0xFFFFFFFF)
val LightTextColor = Color(0xFF333333)

// Dark Theme Colors
val WhitePrimary = Color(0xFFFFFFFF)
val DarkGrayButton = Color(0xFF4A4A4A)
val DarkBackground = Color(0xFF1C1C1C)
val DarkSurface = Color(0xFF2A2A2A)
val DarkTextColor = Color(0xFFE0E0E0)

// Common
val PrimaryContainer = Color(0xFF0D32EE)
val OnPrimaryContainer = Color(0xFF65BFFF)

fun getLightColorScheme(
    primary: Color? = null,
    onPrimary: Color? = null,
    primaryContainer: Color? = null,
    onPrimaryContainer: Color? = null,
    inversePrimary: Color? = null,
    secondary: Color? = null,
    onSecondary: Color? = null,
    secondaryContainer: Color? = null,
    onSecondaryContainer: Color? = null,
    tertiary: Color? = null,
    onTertiary: Color? = null,
    tertiaryContainer: Color? = null,
    onTertiaryContainer: Color? = null,
    background: Color? = null,
    onBackground: Color? = null,
    surface: Color? = null,
    onSurface: Color? = null,
    surfaceVariant: Color? = null,
    onSurfaceVariant: Color? = null,
    surfaceTint: Color? = null,
    inverseSurface: Color? = null,
    inverseOnSurface: Color? = null,
    error: Color? = null,
    onError: Color? = null,
    errorContainer: Color? = null,
    onErrorContainer: Color? = null,
    outline: Color? = null,
    outlineVariant: Color? = null,
    scrim: Color? = null,
    surfaceBright: Color? = null,
    surfaceContainer: Color? = null,
    surfaceContainerHigh: Color? = null,
    surfaceContainerHighest: Color? = null,
    surfaceContainerLow: Color? = null,
    surfaceContainerLowest: Color? = null,
    surfaceDim: Color? = null,
) : ColorScheme {
    return lightColorScheme(
        primary = primary ?:DarkGrayPrimary,
        background = background ?: LightBackground,
        onBackground = onBackground ?: LightTextColor,
        surface = surface ?: LightSurface,
        onSurface = onSurface ?: DarkGrayPrimary,
        secondary = secondary ?: LightGrayButton,
        onSecondary = onSecondary ?:LightTextColor,
        primaryContainer = primaryContainer ?: PrimaryContainer,
        onPrimaryContainer = onPrimaryContainer ?: OnPrimaryContainer,
        onPrimary = onPrimary ?: Color.Unspecified,
        inversePrimary = inversePrimary ?: Color.Unspecified,
        secondaryContainer = secondaryContainer ?: Color.Unspecified,
        onSecondaryContainer = onSecondaryContainer ?: Color.Unspecified,
        tertiary = tertiary ?: Color.Unspecified,
        onTertiary = onTertiary ?: Color.Unspecified,
        tertiaryContainer = tertiaryContainer ?: Color.Unspecified,
        onTertiaryContainer = onTertiaryContainer ?: Color.Unspecified,
        surfaceVariant = surfaceVariant ?: Color.Unspecified,
        onSurfaceVariant = onSurfaceVariant ?: Color.Unspecified,
        surfaceTint = surfaceTint ?: Color.Unspecified,
        inverseSurface = inverseSurface ?: Color.Unspecified,
        inverseOnSurface = inverseOnSurface ?: Color.Unspecified,
        error = error ?: Color.Unspecified,
        onError = onError ?: Color.Unspecified,
        errorContainer = errorContainer ?: Color.Unspecified,
        onErrorContainer = onErrorContainer ?: Color.Unspecified,
        outline = outline ?: Color.Unspecified,
        outlineVariant = outlineVariant ?: Color.Unspecified,
        scrim = scrim ?: Color.Unspecified,
        surfaceBright = surfaceBright ?: Color.Unspecified,
        surfaceContainer = surfaceContainer ?: Color.Unspecified,
        surfaceContainerHigh = surfaceContainerHigh ?: Color.Unspecified,
        surfaceContainerHighest = surfaceContainerHighest ?: Color.Unspecified,
        surfaceContainerLow = surfaceContainerLow ?: Color.Unspecified,
        surfaceContainerLowest = surfaceContainerLowest ?: Color.Unspecified,
        surfaceDim = surfaceDim ?: Color.Unspecified


    )
}

fun getDarkColorScheme(
    primary: Color? = null,
    onPrimary: Color? = null,
    primaryContainer: Color? = null,
    onPrimaryContainer: Color? = null,
    inversePrimary: Color? = null,
    secondary: Color? = null,
    onSecondary: Color? = null,
    secondaryContainer: Color? = null,
    onSecondaryContainer: Color? = null,
    tertiary: Color? = null,
    onTertiary: Color? = null,
    tertiaryContainer: Color? = null,
    onTertiaryContainer: Color? = null,
    background: Color? = null,
    onBackground: Color? = null,
    surface: Color? = null,
    onSurface: Color? = null,
    surfaceVariant: Color? = null,
    onSurfaceVariant: Color? = null,
    surfaceTint: Color? = null,
    inverseSurface: Color? = null,
    inverseOnSurface: Color? = null,
    error: Color? = null,
    onError: Color? = null,
    errorContainer: Color? = null,
    onErrorContainer: Color? = null,
    outline: Color? = null,
    outlineVariant: Color? = null,
    scrim: Color? = null,
    surfaceBright: Color? = null,
    surfaceContainer: Color? = null,
    surfaceContainerHigh: Color? = null,
    surfaceContainerHighest: Color? = null,
    surfaceContainerLow: Color? = null,
    surfaceContainerLowest: Color? = null,
    surfaceDim: Color? = null,
) : ColorScheme {
    return darkColorScheme(
        primary = primary ?: WhitePrimary,
        background = background ?: DarkBackground,
        onBackground = onBackground ?: DarkTextColor,
        surface = surface ?: DarkSurface,
        onSurface = onSurface ?: WhitePrimary,
        secondary = secondary ?: DarkGrayButton,
        onSecondary = onSecondary ?: DarkTextColor,
        primaryContainer = primaryContainer ?: PrimaryContainer,
        onPrimaryContainer = onPrimaryContainer ?: OnPrimaryContainer,
        onPrimary = onPrimary ?: Color.Unspecified,
        inversePrimary = inversePrimary ?: Color.Unspecified,
        secondaryContainer = secondaryContainer ?: Color.Unspecified,
        onSecondaryContainer = onSecondaryContainer ?: Color.Unspecified,
        tertiary = tertiary ?: Color.Unspecified,
        onTertiary = onTertiary ?: Color.Unspecified,
        tertiaryContainer = tertiaryContainer ?: Color.Unspecified,
        onTertiaryContainer = onTertiaryContainer ?: Color.Unspecified,
        surfaceVariant = surfaceVariant ?: Color.Unspecified,
        onSurfaceVariant = onSurfaceVariant ?: Color.Unspecified,
        surfaceTint = surfaceTint ?: Color.Unspecified,
        inverseSurface = inverseSurface ?: Color.Unspecified,
        inverseOnSurface = inverseOnSurface ?: Color.Unspecified,
        error = error ?: Color.Unspecified,
        onError = onError ?: Color.Unspecified,
        errorContainer = errorContainer ?: Color.Unspecified,
        onErrorContainer = onErrorContainer ?: Color.Unspecified,
        outline = outline ?: Color.Unspecified,
        outlineVariant = outlineVariant ?: Color.Unspecified,
        scrim = scrim ?: Color.Unspecified,
        surfaceBright = surfaceBright ?: Color.Unspecified,
        surfaceContainer = surfaceContainer ?: Color.Unspecified,
        surfaceContainerHigh = surfaceContainerHigh ?: Color.Unspecified,
        surfaceContainerHighest = surfaceContainerHighest ?: Color.Unspecified,
        surfaceContainerLow = surfaceContainerLow ?: Color.Unspecified,
        surfaceContainerLowest = surfaceContainerLowest ?: Color.Unspecified,
        surfaceDim = surfaceDim ?: Color.Unspecified

    )
}