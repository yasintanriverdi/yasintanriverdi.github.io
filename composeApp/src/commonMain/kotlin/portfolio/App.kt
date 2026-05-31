package portfolio

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import portfolio.components.*
import portfolio.theme.PortfolioTheme

private val SECTION_MAX_WIDTH = 700.dp
private val SECTION_HORIZONTAL_PADDING = 20.dp

private val SectionModifier = Modifier
    .widthIn(max = SECTION_MAX_WIDTH)
    .padding(horizontal = SECTION_HORIZONTAL_PADDING)

@Composable
fun App() {
    var isDarkTheme by remember { mutableStateOf(true) }
    val scrollState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    // Section indices: 0=hero, 1=career, 2=projects, 3=myapps, 4=education, 5=skills
    PortfolioTheme(isDarkTheme = isDarkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Navbar(
                    isDarkTheme = isDarkTheme,
                    onThemeChange = { isDarkTheme = it },
                    onScrollToSection = { index ->
                        scope.launch {
                            scrollState.animateScrollToItem(index)
                        }
                    }
                )

                LazyColumn(
                    modifier = Modifier.fillMaxSize().weight(1f),
                    state = scrollState,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item(key = "hero") {
                        Column(modifier = SectionModifier) { HeroSection() }
                    }
                    item(key = "career") {
                        Column(modifier = SectionModifier) { ExperienceSection() }
                    }
                    item(key = "projects") {
                        Column(modifier = SectionModifier) { ProjectsSection() }
                    }
                    item(key = "myapps") {
                        Column(modifier = SectionModifier) { MyAppsSection() }
                    }
                    item(key = "education") {
                        Column(modifier = SectionModifier) { EducationSection() }
                    }
                    item(key = "skills") {
                        Column(modifier = SectionModifier) { SkillsSection() }
                    }
                    item(key = "footer") {
                        Column(modifier = SectionModifier) { Footer() }
                    }
                }
            }
        }
    }
}
