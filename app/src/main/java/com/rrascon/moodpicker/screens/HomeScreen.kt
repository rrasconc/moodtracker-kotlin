package com.rrascon.moodpicker.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rrascon.moodpicker.DataManager
import com.rrascon.moodpicker.Mood
import com.rrascon.moodpicker.composables.MoodItem
import com.rrascon.moodpicker.ui.theme.Background
import com.rrascon.moodpicker.ui.theme.Purple

//@Preview
//@Composable
//fun HomeScreen_Preview() {
//    HomeScreen(DataManager)
//}

@Composable
fun HomeScreen(props: DataManager) {
    Column(modifier = Modifier
        .background(Background)
        .padding(16.dp)
        .fillMaxSize()) {

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
                    props.moodOptions.forEach {
                        Box(modifier = Modifier
                            .clip(shape = CircleShape)
                            .clickable { Log.d("Action", "Clicked !") }
                            .padding(16.dp)
                        ) {
                            Text(text = it.emoji,
                                style = MaterialTheme.typography.h4)
                        }

                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Latest mood",
            fontWeight = FontWeight.Bold,
            color = Purple,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column() {
            MoodItem(mood = Mood("Happy", "😁"))
        }

    }
}







