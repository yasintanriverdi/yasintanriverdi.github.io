package portfolio.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.stringArrayResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.profile
import portfolio.composeapp.generated.resources.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.ui.platform.LocalUriHandler
import portfolio.theme.*
import portfolio.icons.AppStoreIcon

@Composable
fun Navbar(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    onScrollToSection: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .border(1.dp, MaterialTheme.colorScheme.outline)
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(stringResource(Res.string.brand_name), color = MaterialTheme.colorScheme.primary, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(stringResource(Res.string.nav_about), color = MaterialTheme.colorScheme.secondary, modifier = Modifier.clickable { onScrollToSection(0) })
            Text(stringResource(Res.string.nav_experience), color = MaterialTheme.colorScheme.secondary, modifier = Modifier.clickable { onScrollToSection(1) })
            Text(stringResource(Res.string.nav_skills), color = MaterialTheme.colorScheme.secondary, modifier = Modifier.clickable { onScrollToSection(5) })
            
            VerticalDivider(modifier = Modifier.height(20.dp), color = MaterialTheme.colorScheme.outline)
            
            // Theme toggle
            IconButton(onClick = { onThemeChange(!isDarkTheme) }) {
                Icon(
                    if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                    contentDescription = stringResource(Res.string.content_desc_theme),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun HeroSection() {
    BoxWithConstraints(modifier = Modifier.padding(vertical = 48.dp).fillMaxWidth()) {
        val isMobile = maxWidth < 600.dp
        
        if (isMobile) {
            Column(
                verticalArrangement = Arrangement.spacedBy(32.dp),
                horizontalAlignment = Alignment.Start
            ) {
                // Image above text on mobile
                painterResource(Res.drawable.profile)?.let { painter ->
                    androidx.compose.foundation.Image(
                        painter = painter,
                        contentDescription = stringResource(Res.string.content_desc_profile),
                        modifier = Modifier.size(160.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                HeroTextAndChips()
            }
        } else {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.weight(1f).padding(end = 32.dp)) {
                    HeroTextAndChips()
                }
                
                // Image on right on desktop
                painterResource(Res.drawable.profile)?.let { painter ->
                    androidx.compose.foundation.Image(
                        painter = painter,
                        contentDescription = stringResource(Res.string.content_desc_profile),
                        modifier = Modifier.size(160.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

@Composable
fun HeroTextAndChips() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(Res.string.hero_name),
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 56.sp
        )
        Text(
            text = stringResource(Res.string.hero_title),
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(Res.string.hero_bio),
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 16.sp,
            lineHeight = 24.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        SocialChips()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SocialChips() {
    val uriHandler = LocalUriHandler.current
    val githubUrl = stringResource(Res.string.github_url)
    val linkedinUrl = stringResource(Res.string.linkedin_url)
    val email = stringResource(Res.string.email)

    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        maxItemsInEachRow = Int.MAX_VALUE
    ) {
        SocialChipPainter(
            painter = painterResource(Res.drawable.ic_github),
            label = stringResource(Res.string.label_github),
            onClick = { uriHandler.openUri(githubUrl) }
        )
        SocialChipPainter(
            painter = painterResource(Res.drawable.ic_linkedin),
            label = stringResource(Res.string.label_linkedin),
            onClick = { uriHandler.openUri(linkedinUrl) }
        )
        SocialChip(
            icon = Icons.Default.Mail,
            label = stringResource(Res.string.label_email),
            onClick = { uriHandler.openUri("mailto:$email") }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SocialChip(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
        modifier = Modifier.height(32.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp).fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon(
                icon,
                contentDescription = label,
                modifier = Modifier.size(16.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                label,
                fontSize = 12.sp,
                lineHeight = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SocialChipPainter(painter: androidx.compose.ui.graphics.painter.Painter, label: String, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
        modifier = Modifier.height(32.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp).fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon(
                painter = painter,
                contentDescription = label,
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                label,
                fontSize = 12.sp,
                lineHeight = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreLinkButton(
    label: String,
    onClick: () -> Unit,
    icon: androidx.compose.ui.graphics.vector.ImageVector? = null,
    painter: androidx.compose.ui.graphics.painter.Painter? = null
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
        modifier = Modifier.height(56.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp).fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            } else if (painter != null) {
                Icon(
                    painter = painter,
                    contentDescription = label,
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            Text(
                label,
                fontSize = 14.sp,
                lineHeight = 14.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun ExperienceSection() {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp)) {
        SectionTitle(stringResource(Res.string.section_career))
        Spacer(modifier = Modifier.height(32.dp))
        
        ExperienceItem(
            role = stringResource(Res.string.ebay_role),
            company = stringResource(Res.string.ebay_company),
            date = stringResource(Res.string.ebay_date),
            duties = stringArrayResource(Res.array.ebay_duties)
        )
        
        ExperienceItem(
            role = stringResource(Res.string.zenjob_role),
            company = stringResource(Res.string.zenjob_company),
            date = stringResource(Res.string.zenjob_date),
            duties = stringArrayResource(Res.array.zenjob_duties)
        )
        
        ExperienceItem(
            role = stringResource(Res.string.argela_role),
            company = stringResource(Res.string.argela_company),
            date = stringResource(Res.string.argela_date),
            duties = stringArrayResource(Res.array.argela_duties)
        )

        ExperienceItem(
            role = stringResource(Res.string.huawei_role),
            company = stringResource(Res.string.huawei_company),
            date = stringResource(Res.string.huawei_date),
            duties = stringArrayResource(Res.array.huawei_duties)
        )

        ExperienceItem(
            role = stringResource(Res.string.netas_role_engineer),
            company = stringResource(Res.string.netas_company),
            date = stringResource(Res.string.netas_engineer_date),
            duties = stringArrayResource(Res.array.netas_engineer_duties)
        )

        ExperienceItem(
            role = stringResource(Res.string.netas_role_intern),
            company = stringResource(Res.string.netas_company),
            date = stringResource(Res.string.netas_intern_date),
            duties = stringArrayResource(Res.array.netas_intern_duties)
        )
    }
}

@Composable
fun ProjectsSection() {
    val uriHandler = LocalUriHandler.current
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp)) {
        SectionTitle(stringResource(Res.string.section_projects))
        Spacer(modifier = Modifier.height(32.dp))

        SupportedProjectItem(
            title = stringResource(Res.string.ebay_app_title),
            description = stringResource(Res.string.ebay_app_desc),
            url = stringResource(Res.string.ebay_app_url),
            onOpen = { uriHandler.openUri(it) }
        )
        SupportedProjectItem(
            title = stringResource(Res.string.zenjob_app_title),
            description = stringResource(Res.string.zenjob_app_desc),
            url = stringResource(Res.string.zenjob_app_url),
            onOpen = { uriHandler.openUri(it) }
        )
        SupportedProjectItem(
            title = stringResource(Res.string.lenz_app_title),
            description = stringResource(Res.string.lenz_app_desc),
            url = stringResource(Res.string.lenz_app_url),
            onOpen = { uriHandler.openUri(it) }
        )
        SupportedProjectItem(
            title = stringResource(Res.string.hola_app_title),
            description = stringResource(Res.string.hola_app_desc),
            url = stringResource(Res.string.hola_app_url),
            onOpen = { uriHandler.openUri(it) }
        )
    }
}

@Composable
fun MyAppsSection() {
    val uriHandler = LocalUriHandler.current
    val playUrl = stringResource(Res.string.my_apps_google_play_url)
    val storeUrl = stringResource(Res.string.my_apps_app_store_url)
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp)) {
        SectionTitle(stringResource(Res.string.section_my_apps))
        Spacer(modifier = Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StoreLinkButton(
                painter = painterResource(Res.drawable.ic_google_play_modern),
                label = stringResource(Res.string.label_google_play),
                onClick = { uriHandler.openUri(playUrl) }
            )
            StoreLinkButton(
                icon = AppStoreIcon,
                label = stringResource(Res.string.label_app_store),
                onClick = { uriHandler.openUri(storeUrl) }
            )
        }
    }
}

@Composable
fun EducationSection() {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp)) {
        SectionTitle(stringResource(Res.string.section_education))
        Spacer(modifier = Modifier.height(32.dp))
        
        ExperienceItem(
            role = stringResource(Res.string.edu_master_role),
            company = stringResource(Res.string.edu_university),
            date = stringResource(Res.string.edu_master_date),
            duties = emptyList()
        )
        
        ExperienceItem(
            role = stringResource(Res.string.edu_bachelor_role),
            company = stringResource(Res.string.edu_university),
            date = stringResource(Res.string.edu_bachelor_date),
            duties = emptyList()
        )
    }
}

@Composable
fun SkillsSection() {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp)) {
        SectionTitle(stringResource(Res.string.section_technical_expertise))
        Spacer(modifier = Modifier.height(24.dp))
        
        SkillCategory(stringResource(Res.string.skill_cat_arch), stringArrayResource(Res.array.skills_arch))
        SkillCategory(stringResource(Res.string.skill_cat_core), stringArrayResource(Res.array.skills_core))
        SkillCategory(stringResource(Res.string.skill_cat_perf), stringArrayResource(Res.array.skills_perf))
        SkillCategory(stringResource(Res.string.skill_cat_lead), stringArrayResource(Res.array.skills_lead))
    }
}

@Composable
fun Footer() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(Res.string.footer_built_with), color = MaterialTheme.colorScheme.secondary, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(stringResource(Res.string.footer_copyright), color = MaterialTheme.colorScheme.secondary, fontSize = 14.sp)
    }
}

// --- Shared Components ---

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ExperienceItem(role: String, company: String, date: String, duties: List<String>) {
    Column(modifier = Modifier.padding(bottom = 32.dp)) {
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(role, color = MaterialTheme.colorScheme.onBackground, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            if (company.isNotEmpty()) {
                Text("@ $company", color = MaterialTheme.colorScheme.secondary, fontSize = 18.sp)
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(date, color = MaterialTheme.colorScheme.secondary, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(12.dp))
        
        duties.forEach { duty ->
            Row(modifier = Modifier.padding(bottom = 8.dp)) {
                Text("— ", color = MaterialTheme.colorScheme.outline)
                Text(duty, color = MaterialTheme.colorScheme.secondary, fontSize = 14.sp, lineHeight = 20.sp)
            }
        }
    }
}

@Composable
fun SupportedProjectItem(title: String, description: String, url: String, onOpen: (String) -> Unit) {
    Column(modifier = Modifier.padding(bottom = 28.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = MaterialTheme.colorScheme.onBackground, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(description, color = MaterialTheme.colorScheme.secondary, fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.width(16.dp))
            SocialChip(
                icon = Icons.AutoMirrored.Filled.OpenInNew,
                label = stringResource(Res.string.label_view_on_play_store),
                onClick = { onOpen(url) }
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillCategory(title: String, skills: List<String>) {
    Column(modifier = Modifier.padding(bottom = 24.dp)) {
        Text(title, color = MaterialTheme.colorScheme.onBackground, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            maxItemsInEachRow = Int.MAX_VALUE
        ) {
            skills.forEach { skill ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(16.dp))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = skill,
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 14.sp,
                        lineHeight = 14.sp,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
            }
        }
    }
}
