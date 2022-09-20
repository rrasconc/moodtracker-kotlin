package com.rrascon.moodpicker

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class DataManager(app: Application) : AndroidViewModel(app) {
    var moodOptions: List<Mood> = listOf(
        Mood("Anxious", "😖"),
        Mood("Happy", "🥰"),
        Mood("Happy", "😁"),
        Mood("Happy", "😢"))
}