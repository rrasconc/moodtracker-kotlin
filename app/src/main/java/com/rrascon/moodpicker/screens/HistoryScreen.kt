package com.rrascon.moodpicker.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rrascon.moodpicker.DataManager
import com.rrascon.moodpicker.Mood
import com.rrascon.moodpicker.MoodRecord
import com.rrascon.moodpicker.composables.MoodItem
import com.rrascon.moodpicker.ui.theme.Background

@Composable
fun HistoryScreen(props: DataManager) {
    Column(modifier = Modifier
        .background(Background)
        .padding(16.dp)
        .fillMaxSize()
    ) {
        props.moodRecords.forEach {
            MoodItem(moodRecord = MoodRecord(mood= Mood(it.mood.name, it.mood.emoji), date = it.date),
                onDelete = {} )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}