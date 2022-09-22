package com.rrascon.moodpicker.screens

import android.graphics.fonts.Font
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rrascon.moodpicker.DataManager
import com.rrascon.moodpicker.Mood
import com.rrascon.moodpicker.MoodRecord
import com.rrascon.moodpicker.composables.MoodItem
import com.rrascon.moodpicker.ui.theme.Background
import com.rrascon.moodpicker.ui.theme.Purple
import java.text.SimpleDateFormat
import java.util.*

//@Preview
//@Composable
//fun HomeScreen_Preview() {
//    HomeScreen(DataManager)
//}

@Composable
fun HomeScreen(props: DataManager) {
    var selectedMood = remember { mutableStateOf(Mood("","")) }

    Column(modifier = Modifier
        .background(Background)
        .padding(16.dp)
        .fillMaxSize()) {
        Spacer(modifier = Modifier.height(80.dp))
        Box(Modifier
            .clip(RoundedCornerShape(16.dp))) {

            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = "How are you feeling?",
                    fontWeight = FontWeight.Bold,
                    color = Purple,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(16.dp)
                )
                Row {
                    props.moodOptions.forEach { mood ->
                        Box(modifier = Modifier
                            .clip(shape = CircleShape)
                            .clickable { selectedMood.value = mood }
                            .let {
                                if (selectedMood.value.name == mood.name) {
                                    return@let it
                                        .background(Purple)
                                }
                                it
                            }
                            .padding(16.dp)
                        ) {
                            Text(text = mood.emoji,
                                style = MaterialTheme.typography.h4)
                        }

                    }
                }

                Spacer(Modifier.height(16.dp))
                
                if (selectedMood.value.name !== "") {
                     Box(modifier = Modifier
                         .clip(RoundedCornerShape(24.dp))
                         .clickable {
                             props.addMoodRecord(selectedMood.value)
                         }
                         .background(Purple)
                         .padding(horizontal = 24.dp, vertical = 8.dp)
                         ) {
                         Text(text = "Record",
                             fontWeight = FontWeight.Bold,
                             color= Color.White
                         )
                     }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Latest moods",
            fontWeight = FontWeight.Bold,
            color = Purple,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column() {
//            props.moodRecords.forEach {
//                MoodItem(mood = Mood(it.mood.name, it.mood.emoji), date = it.date)
//                Spacer(modifier = Modifier.height(8.dp))
//            }
            if(props.moodRecords.isNotEmpty()){
                val lastIndex = props.moodRecords.lastIndex
                MoodItem(mood = Mood(props.moodRecords[lastIndex].mood.name, props.moodRecords[lastIndex].mood.emoji),
                    date = props.moodRecords[lastIndex].date)
            }

        }

    }
}







