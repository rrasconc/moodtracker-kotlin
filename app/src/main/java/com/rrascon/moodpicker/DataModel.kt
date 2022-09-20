package com.rrascon.moodpicker

import java.util.Date

class Mood(
    var name: String,
    var emoji: String,
)

class MoodRecord(var mood: Mood, var date: Date)