package com.harzan7.calculator.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = DarkGray,
    secondary = DarkOrange,
    tertiary = DarkGreen,
    background = Color.Black,
    surface = DarkSurface,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = DarkOnBackground,
    onSurface = DarkOnSurface,
    error = DarkRed,        // color for "C", "AC" buttons
    onError = Color.Black
)

private val LightColorScheme = lightColorScheme(
    primary = LightGray,
    secondary = LightOrange,
    tertiary = LightGreen,
    background = LightBackground,
    surface = LightSurface,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = LightOnBackground,
    onSurface = LightOnSurface,
    error = LightRed,       // color for "C", "AC" buttons
    onError = Color.White
)

@Composable
fun CalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

val ColorScheme.clearButton: Color
    @Composable get() = error

val ColorScheme.operationButton: Color
    @Composable get() = secondary

val ColorScheme.equalsButton: Color
    @Composable get() = tertiary

val ColorScheme.numberButton: Color
    @Composable get() = primary