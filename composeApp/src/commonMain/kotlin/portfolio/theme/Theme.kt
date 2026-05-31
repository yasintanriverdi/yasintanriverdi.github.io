package portfolio.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DarkBgColor = Color(0xFF0D0D0D)
val DarkTextPrimary = Color(0xFFEDEDED)
val DarkTextSecondary = Color(0xFF8A8A8A)
val DarkAccent = Color(0xFFFFFFFF)
val DarkBorderColor = Color(0xFF2A2A2A)

val LightBgColor = Color(0xFFF5F5F5)
val LightTextPrimary = Color(0xFF111111)
val LightTextSecondary = Color(0xFF555555)
val LightAccent = Color(0xFF000000)
val LightBorderColor = Color(0xFFE0E0E0)

val DarkColorScheme = darkColorScheme(
    background = DarkBgColor,
    surface = DarkBgColor,
    onBackground = DarkTextPrimary,
    onSurface = DarkTextPrimary,
    primary = DarkAccent,
    secondary = DarkTextSecondary,
    outline = DarkBorderColor
)

val LightColorScheme = lightColorScheme(
    background = LightBgColor,
    surface = LightBgColor,
    onBackground = LightTextPrimary,
    onSurface = LightTextPrimary,
    primary = LightAccent,
    secondary = LightTextSecondary,
    outline = LightBorderColor
)

@Composable
fun PortfolioTheme(
    isDarkTheme: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (isDarkTheme) DarkColorScheme else LightColorScheme,
        content = content
    )
}
