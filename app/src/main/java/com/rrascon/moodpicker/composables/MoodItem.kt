package com.rrascon.moodpicker.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rrascon.moodpicker.Mood
import com.rrascon.moodpicker.ui.theme.Lavender
import com.rrascon.moodpicker.ui.theme.Purple
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun MoodItem(mood: Mood) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(8.dp))
        .background(Color.White)
        .padding(16.dp)
        .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                ) {
                Text(text = mood.emoji,
                    style = MaterialTheme.typography.h5
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = mood.name,
                    fontWeight = FontWeight.Bold,
                    color = Purple,
                )
            }
            Text(text = "20 Sep, 2022 at 3:44pm",
                color = Lavender,
            )
            Text(text = "Delete",
                fontWeight = FontWeight.Bold,
                color = Lavender,
            )
        }
    }
}