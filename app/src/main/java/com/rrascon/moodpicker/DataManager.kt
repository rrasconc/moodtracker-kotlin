package com.rrascon.moodpicker

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import java.util.*

class DataManager(app: Application) : AndroidViewModel(app) {
    var moodOptions: List<Mood> = listOf(
        Mood("Anxious", "😖"),
        Mood("In love", "🥰"),
        Mood("Happy", "😁"),
        Mood("Sad", "😢"))

    var moodRecords: List<MoodRecord> by mutableStateOf(listOf())

    fun addMoodRecord(mood: Mood) {
        moodRecords = listOf(*moodRecords.toTypedArray(), MoodRecord(mood, Date()))
    }

}