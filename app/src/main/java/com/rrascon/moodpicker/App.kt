package com.rrascon.moodpicker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rrascon.moodpicker.screens.HistoryScreen
import com.rrascon.moodpicker.screens.HomeScreen
import com.rrascon.moodpicker.ui.theme.Purple

@Composable
fun App(dataManager: DataManager) {
    var selectedRoute = remember {
        mutableStateOf(Routes.HomePage)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                elevation = 0.dp
            ) {
                AppTitle(selectedRoute.value.title)
            }
        },
        content = {
            when(selectedRoute.value.route) {
                Routes.HomePage.route -> HomeScreen(dataManager)
                Routes.HistoryPage.route -> HistoryScreen(dataManager)
            }
        },
        bottomBar = {
            BottomTab(selectedRoute = selectedRoute.value.route ,onChange = {
                selectedRoute.value = it
            })
        }
    )
}

@Composable
fun AppTitle(title :String) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()) {
        Text(text = title,
            color = Purple,
            fontWeight = FontWeight.Bold)
    }
}