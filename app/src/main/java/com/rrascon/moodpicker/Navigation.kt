package com.rrascon.moodpicker

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.IconCompat.IconType
import com.rrascon.moodpicker.ui.theme.Lavender
import com.rrascon.moodpicker.ui.theme.Purple

data class NavigationPage(
    var title: String,
    var icon: ImageVector,
    var route: String
)

object Routes {
    val HomePage = NavigationPage(title = "Current mood", icon = Icons.Filled.Home, route = "home")
    val HistoryPage = NavigationPage(title = "Past moods",icon = Icons.Filled.History, route = "history")

    val pages = listOf(HomePage, HistoryPage)
}

@Composable
fun BottomTabItem(page: NavigationPage,
                  selected: Boolean = false,
                  modifier: Modifier = Modifier) {

    Box(modifier = modifier){

        Icon(page.icon,
            contentDescription = page.title,
            tint = if(selected) Purple else Lavender,
            modifier = Modifier
                .size(28.dp))
    }
}

@Composable
fun BottomTab(
    selectedRoute: String = Routes.HomePage.route,
    onChange: (NavigationPage)-> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Routes.pages.forEach {
            BottomTabItem(
                page = it,
                selected = selectedRoute == it.route,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .clickable {
                        onChange(it)
                    }
                    .padding(16.dp)

            )
        }
    }
}