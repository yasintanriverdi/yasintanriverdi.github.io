import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import portfolio.App
import portfolio.theme.PortfolioTheme

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget", title = "Yasin Tanriverdi | Android Engineer") {
        App()
    }
}
