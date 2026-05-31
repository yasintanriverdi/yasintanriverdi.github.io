package portfolio.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

// Modern Google Play Store icon removed from here.

// Apple logo icon (SimpleIcons paths) – compiled Kotlin ImageVector.
val AppStoreIcon: ImageVector by lazy {
    ImageVector.Builder(
        name = "AppStore",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
        path(fill = SolidColor(Color.White)) {
            // Leaf / bite mark
            moveTo(14.94f, 5.19f)
            arcTo(4.38f, 4.38f, 0f, isMoreThanHalf = false, isPositiveArc = false, x1 = 16f, y1 = 2f)
            arcTo(4.44f, 4.44f, 0f, isMoreThanHalf = false, isPositiveArc = false, x1 = 13f, y1 = 3.52f)
            arcTo(4.13f, 4.13f, 0f, isMoreThanHalf = false, isPositiveArc = false, x1 = 12f, y1 = 6.61f)
            arcTo(3.69f, 3.69f, 0f, isMoreThanHalf = false, isPositiveArc = false, x1 = 14.94f, y1 = 5.19f)
            close()

            // Main apple body
            moveTo(17.46f, 12.63f)
            arcToRelative(4.51f, 4.51f, 0f, isMoreThanHalf = false, isPositiveArc = true, dx1 = 2.16f, dy1 = -3.81f)
            arcToRelative(4.66f, 4.66f, 0f, isMoreThanHalf = false, isPositiveArc = false, dx1 = -3.66f, dy1 = -2f)
            curveToRelative(-1.56f, -0.16f, -3f, 0.91f, -3.83f, 0.91f)
            reflectiveCurveToRelative(-2f, -0.89f, -3.3f, -0.87f)
            arcTo(4.92f, 4.92f, 0f, isMoreThanHalf = false, isPositiveArc = false, x1 = 4.69f, y1 = 9.39f)
            curveTo(2.93f, 12.45f, 4.24f, 17f, 6f, 19.47f)
            curveTo(6.8f, 20.68f, 7.8f, 22.05f, 9.12f, 22f)
            reflectiveCurveToRelative(1.75f, -0.82f, 3.28f, -0.82f)
            reflectiveCurveToRelative(2f, 0.82f, 3.3f, 0.79f)
            reflectiveCurveToRelative(2.22f, -1.24f, 3.06f, -2.45f)
            arcToRelative(11f, 11f, 0f, isMoreThanHalf = false, isPositiveArc = false, dx1 = 1.38f, dy1 = -2.85f)
            arcTo(4.41f, 4.41f, 0f, isMoreThanHalf = false, isPositiveArc = true, x1 = 17.46f, y1 = 12.63f)
            close()
        }
    }.build()
}
